package PW_15.Task2;

import PW_15.Task2.PaymentService;

public class ServiceFactory {

    public static PaymentService create(String className) {
        try {
            // Крок 1: отримуємо Class<?> за іменем класу
            Class<?> clazz = Class.forName(className);

            // Крок 2: перевіряємо що клас реалізує PaymentService
            if (!PaymentService.class.isAssignableFrom(clazz)) {
                throw new ServiceCreationException("Клас '" + className + "' не реалізує PaymentService");
            }

            // Крок 3: знаходимо конструктор без аргументів і створюємо об'єкт
            return (PaymentService) clazz.getConstructor().newInstance();

        } catch (ClassNotFoundException e) {
            throw new ServiceCreationException("Клас не знайдено: " + className, e);
        } catch (NoSuchMethodException e) {
            throw new ServiceCreationException("Немає конструктора без аргументів: " + className, e);
        } catch (Exception e) {
            throw new ServiceCreationException("Помилка створення: " + className, e);
        }
    }

    public static class ServiceCreationException extends RuntimeException {
        public ServiceCreationException(String message) { super(message); }
        public ServiceCreationException(String message, Throwable cause) { super(message, cause); }
    }
}