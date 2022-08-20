package cache;

import annotations.Cachable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CacheValidator {

    public static void validation(Object o) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Cachable.class)) {
                Cachable an = method.getAnnotation(Cachable.class);

                String filePrefix = an.filePrefix();
                boolean zip = an.zip();

                Field fieldPath = clazz.getDeclaredField("filename");
                fieldPath.setAccessible(true);
                Field fieldZip = clazz.getDeclaredField("zip");
                fieldZip.setAccessible(true);

                String valueOfFile = fieldPath.get(o).toString();
                boolean valueOfZip = Boolean.parseBoolean(fieldZip.get(o).toString());

                if (!valueOfFile.startsWith(filePrefix)) {
                    throw new IllegalStateException(method.getName()
                            + " error. File name must be starts with \"" + filePrefix + "\"");
                }

                if (valueOfZip != zip){
                    throw new IllegalStateException(method.getName()
                            + " error. Convert in ZIP format must be " + zip);
                }
            }
        }
    }
}
