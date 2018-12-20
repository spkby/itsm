package front.utils.postprocessor;

import front.DAO.impl.IAuditDAO;
import front.models.Audit;
import front.utils.UserHelper;
import front.utils.annotation.AuditSuccessType;
import front.utils.annotation.Auditable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuditableAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Lazy
    @Autowired
    IAuditDAO auditDAO;
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        boolean hasAudMethod = Arrays.stream(bean.getClass().getMethods())
                .anyMatch(m -> m.getAnnotation(Auditable.class) != null);

        if (hasAudMethod) {
            map.put(beanName, bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Class originalClass = map.get(beanName).getClass();
            System.out.println(beanName);
            return Proxy.newProxyInstance(
                    originalClass.getClassLoader(),
                    originalClass.getInterfaces(),
                    (proxy, method, args) -> {

                        Integer auditSuccessType = null;
                        String auditOperationType = null;
                        String auditEntityType = null;

                        try {
                            Annotation annotation =
                                    originalClass.getMethod(
                                            method.getName(),
                                            method.getParameterTypes()).getAnnotation(Auditable.class);
                            if (annotation != null) {
                                Auditable auditableAnnotation = (Auditable) annotation;
                                auditOperationType = auditableAnnotation.AUDIT_TYPE().name();
                                auditEntityType = auditableAnnotation.ENTITY_TYPE().name();
                                auditSuccessType = AuditSuccessType.SUCCESS.getAuditSuccessTypeId();
                            }
                            //throw new RuntimeException();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } finally {
                            if (auditSuccessType == null) {
                                auditSuccessType = AuditSuccessType.FAILED.getAuditSuccessTypeId();
                            }
                            auditDAO.create(new Audit(auditSuccessType, auditOperationType, LocalDateTime.now(), UserHelper.getCurrentUser(),auditEntityType));
                        }
                        return method.invoke(bean, args);
                    }
            );
        }
        return bean;
    }
}

