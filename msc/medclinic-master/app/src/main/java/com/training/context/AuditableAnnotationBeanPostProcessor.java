package com.training.context;

import com.training.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


@Component
public class AuditableAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Object> map = new HashMap<>();

    @Autowired
    @Lazy
    private AuditService auditService;

    @Autowired
    @Lazy
    private UserHolder userHolder;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Method[] methods = bean.getClass().getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Auditable.class) != null) {
                map.put(beanName, bean);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Object originalBeanClass = map.get(beanName);
        if (originalBeanClass != null) {
            return Proxy.newProxyInstance(originalBeanClass.getClass().getClassLoader(), originalBeanClass.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        Object result = null;

                                boolean success = true;
                                try {
                                    result = method.invoke(originalBeanClass, args);
                                } catch (final Throwable e) {
                                    success = false;
                                    throw e.getCause();
                                } finally {
                                    auditService.create(success, userHolder.getName(), args);
                                }
                        return result;
                    });
        }
        return bean;
    }

}
