package ua.com.illia.configutator.impl;

import ua.com.illia.DIFrameworkApplication;
import ua.com.illia.annotations.Value;
import ua.com.illia.configutator.BeanConfigurator;

import java.lang.reflect.Field;
import java.util.Map;

public class ValueAnnotationBeanConfigurator implements BeanConfigurator {

    private final Map<String, String> propertiesMap = DIFrameworkApplication.getProperiesMap();

    @Override
    public void configure(Object bean) {

        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Value.class)) {
                Value property = field.getAnnotation(Value.class);
                String value = property.value();
                String props = propertiesMap.get(value);
                field.setAccessible(true);
                try {
                    field.set(bean, props);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
