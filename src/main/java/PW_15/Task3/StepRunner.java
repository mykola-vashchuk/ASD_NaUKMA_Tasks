package PW_15.Task3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StepRunner {

    public static void run(Object target) {
        Class<?> clazz = target.getClass();
        System.out.println("StepRunner запущено для: " + clazz.getSimpleName());

        // 1. Збираємо всі методи класу (включаючи private)
        List<Method> stepMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(Step.class))
                .collect(Collectors.toList());

        if (stepMethods.isEmpty()) {
            System.out.println("Жодного @Step методу не знайдено.");
            return;
        }

        // 2. Валідуємо сигнатуру кожного методу
        for (Method m : stepMethods) {
            if (!m.getReturnType().equals(void.class)) {
                throw new StepValidationException(
                        "Метод @Step '" + m.getName() + "' повинен повертати void, " +
                                "але повертає: " + m.getReturnType().getSimpleName()
                );
            }
            if (m.getParameterCount() > 0) {
                throw new StepValidationException(
                        "Метод @Step '" + m.getName() + "' не повинен мати аргументів, " +
                                "але має: " + m.getParameterCount()
                );
            }
        }

        // 3. Сортуємо за order
        stepMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Step.class).order()));

        // 4. Виконуємо кожен крок
        for (Method m : stepMethods) {
            Step ann = m.getAnnotation(Step.class);
            System.out.printf("Крок %d: %s [%s]%n", ann.order(),
                    ann.description().isEmpty() ? m.getName() : ann.description(),
                    m.getName());

            // Дозволяємо виклик приватних методів
            m.setAccessible(true);

            try {
                m.invoke(target);
            } catch (java.lang.reflect.InvocationTargetException e) {
                // InvocationTargetException загортає реальний виняток з методу
                throw new StepExecutionException(
                        "Помилка в кроці " + ann.order() + " [" + m.getName() + "]: "
                                + e.getCause().getMessage(),
                        e.getCause()
                );
            } catch (IllegalAccessException e) {
                throw new StepExecutionException("Немає доступу до методу: " + m.getName(), e);
            }
        }

        System.out.println("Усі кроки виконано.");
    }

    public static class StepValidationException extends RuntimeException {
        public StepValidationException(String message) { super(message); }
    }

    public static class StepExecutionException extends RuntimeException {
        public StepExecutionException(String message, Throwable cause) { super(message, cause); }
    }
}
