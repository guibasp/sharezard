package br.com.sharezard.utils;

import org.springframework.context.annotation.Bean;

import java.lang.reflect.Field;

public class ObjectUpdater <T> {

    public T updateObject(T target, T source) {
        if (target == null || source == null)
            return target;

        Class<?> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object sourceValue = field.get(source);
                if (sourceValue != null) {
                    field.set(target, sourceValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return target;
    }

}
