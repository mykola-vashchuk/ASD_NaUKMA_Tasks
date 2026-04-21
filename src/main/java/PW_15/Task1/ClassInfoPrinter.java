package PW_15.Task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassInfoPrinter {

    public static void print(Class<?> clazz) {
        System.out.println("=== Reflection-інспектор: " + clazz.getSimpleName() + " ===");

        // 1. Ім'я класу
        System.out.println("getName()       : " + clazz.getName());
        System.out.println("getSimpleName() : " + clazz.getSimpleName());

        // 2. Суперклас
        System.out.println("getSuperclass() : " + clazz.getSuperclass().getName());

        // 3. Інтерфейси
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length == 0) {
            System.out.println("getInterfaces() : (немає)");
        } else {
            System.out.println("getInterfaces() :");
            for (Class<?> i : interfaces) {
                System.out.println("   - " + i.getName());
            }
        }

        // 4. Поля (включно з private)
        System.out.println("getDeclaredFields() :");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.printf("   [%s] %s %s%n",
                    Modifier.toString(f.getModifiers()),
                    f.getType().getSimpleName(),
                    f.getName());
        }

        // 5. Методи (включно з private)
        System.out.println("getDeclaredMethods() :");
        for (Method m : clazz.getDeclaredMethods()) {
            String params = Arrays.stream(m.getParameterTypes())
                    .map(Class::getSimpleName)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
            System.out.printf("   [%s] %s %s(%s)%n",
                    Modifier.toString(m.getModifiers()),
                    m.getReturnType().getSimpleName(),
                    m.getName(),
                    params);
        }
    }
}
