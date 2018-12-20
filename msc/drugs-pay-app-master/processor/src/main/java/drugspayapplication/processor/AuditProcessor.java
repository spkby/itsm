package drugspayapplication.processor;

import drugspayapplication.entity.Audit;
import drugspayapplication.entity.Transaction;
import drugspayapplication.repository.AuditRepository;
import drugspayapplication.service.TransactionServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;
import java.time.LocalDate;

@Service
public class AuditProcessor implements BeanPostProcessor {
    @Autowired
    private AuditRepository auditRepository;
    private static final String ACTION_STRING = "Patient %d Product %s";

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        boolean match = bean.getClass().getName().equals(TransactionServiceImpl.class.getName());
        if (match) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        Object result = method.invoke(bean, args);
                        if (method.getName().equals("postTransaction")) {
                            boolean flag = (boolean) result;
                            Transaction transaction = (Transaction) args[0];
                            String message = String.format(ACTION_STRING, transaction.getPatient().getId(),
                                    transaction.getProduct().getName());
                            Audit audit = new Audit(LocalDate.now(), flag, message);
                            auditRepository.save(audit);
                        }
                        return result;
                    });
        }
        return bean;
    }
}
