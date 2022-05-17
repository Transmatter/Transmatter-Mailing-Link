package transmatter.project.security.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SimpleUtils {
    public static <T> T clone(T source, T target, String... excludeNames)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        T result = (T) source.getClass().getConstructor().newInstance();
        List<String> excludeList = Arrays.asList(excludeNames);
        // read all source fields
        for (Field field : getFields(source)) {
            if (Modifier.isFinal(field.getModifiers())) {// if final skip everything else
                continue;
            }
            if (excludeList.contains(field.getName())) {
                continue;
            }
            field.setAccessible(true);
            if (field.get(source) != null && !Collection.class.isAssignableFrom(field.getType())) {

                field.set(target, field.get(source));
            }
        }

        return target;
    }

    private static <T> List<Field> getFields(T t) {
        List<Field> fields = new ArrayList<>();
        Class clazz = t.getClass();
        while (clazz != Object.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
