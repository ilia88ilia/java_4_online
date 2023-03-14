package ua.com.illia.configutator.impl;

import ua.com.illia.BeanFactory;
import ua.com.illia.annotations.InjectBean;
import ua.com.illia.configutator.BeanConfigurator;

import java.lang.reflect.Field;

public class InjectBeanAnnotationBeanConfigurator implements BeanConfigurator {

    @Override
    public void configure(Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectBean.class)) {
                Object dependency = BeanFactory.getBeanMap().get(field.getType());
                field.setAccessible(true);
                try {
                    field.set(bean, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
