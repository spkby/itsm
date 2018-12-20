package com.itsm.pub.courses.patients.front.context;

import com.itsm.pub.courses.patients.front.repository.domain.IAuditRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuditableAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Object> map = new HashMap<>();

    @Autowired
    @Lazy
    private IAuditRepository repo;

    @Autowired
    @Lazy
    private UserNameHolder nameHolder;

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
            Object original = map.get(beanName);
            return Proxy.newProxyInstance(
                    original.getClass().getClassLoader(),
                    original.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        boolean success = true;
                        Object result;
                        try {
                            result = method.invoke(bean, args);
                        } catch (final Throwable e){
                            success = false;
                            throw e.getCause();
                        } finally {
                            if (original.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(Auditable.class) != null) {
                                repo.create(success,nameHolder.getCurrentName(), args);
                            }
                        }

                        return result;
                    }
            );

        }
        return bean;
    }
}
