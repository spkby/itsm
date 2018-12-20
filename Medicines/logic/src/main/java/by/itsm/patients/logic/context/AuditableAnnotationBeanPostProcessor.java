package by.itsm.patients.logic.context;

import by.itsm.patients.logic.AuditEnabled;
import by.itsm.patients.logic.service.domain.IAuditService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@Component
public class AuditableAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    @Lazy
    private AuditEnabled isAuditEnable;

    @Autowired
    @Lazy
    private UserHolder nameHolder;

    @Autowired
    @Lazy
    private IAuditService auditService;

    private Map<String, AnnotatedMethodsInBean> methods = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Method[] beanMethods = bean.getClass().getMethods();
        for (Method method : beanMethods) {
            if (method.isAnnotationPresent(Auditable.class)) {

                AnnotatedMethodsInBean annotatedMethodsInBean = methods.get(beanName);
                if (annotatedMethodsInBean == null) {
                    methods.put(beanName, annotatedMethodsInBean = new AnnotatedMethodsInBean());
                    annotatedMethodsInBean.setOriginalBean(bean);
                }

                if (annotatedMethodsInBean.isNull()) {
                    annotatedMethodsInBean.setMethods(new ArrayList<>());
                }
                annotatedMethodsInBean.add(method);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (methods.containsKey(beanName)) {
            Object original = methods.get(beanName).getOriginalBean();
            return Proxy.newProxyInstance(
                    original.getClass().getClassLoader(),
                    original.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        Object result;

                        List<String> methodList = this.methods.get(beanName).getMethodNames();

                        if (isAuditEnable.isEnabled() && methodList.contains(method.getName())) {

                            boolean success = true;

                            try {

                                result = method.invoke(original, args);

                            } catch (InvocationTargetException e) {
                                success = false;
                                throw e.getCause();
                            } finally {

                                auditService.add(success, UserHolder.getCurrentUser(), args);
                            }
                        } else {
                            result = method.invoke(original, args);
                        }

                        return result;
                    });
        }
        return bean;
    }

    private class AnnotatedMethodsInBean {

        List<String> methodNames;
        Object originalBean;

        private List<String> getMethodNames() {
            return methodNames;
        }

        private void setMethods(List<String> methodNames) {
            this.methodNames = methodNames;
        }

        private Object getOriginalBean() {
            return originalBean;
        }

        private void setOriginalBean(Object originalBean) {
            this.originalBean = originalBean;
        }

        private void add(Method method) {
            methodNames.add(method.getName());
        }

        private boolean isNull() {
            return methodNames == null;
        }

    }
}
