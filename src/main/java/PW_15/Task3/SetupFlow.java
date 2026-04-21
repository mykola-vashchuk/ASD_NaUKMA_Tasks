package PW_15.Task3;

public class SetupFlow {

    @Step(order = 1, description = "Ініціалізація конфігурації")
    public void initConfig() {
        System.out.println("   Конфігурацію завантажено.");
    }

    @Step(order = 2, description = "Підключення до бази даних")
    public void connectDatabase() {
        System.out.println("   З'єднання з БД встановлено.");
    }

    @Step(order = 3, description = "Міграція схеми (private метод)")
    private void runMigrations() {
        // private — StepRunner виклике через setAccessible(true)
        System.out.println("   Міграції виконано.");
    }

    @Step(order = 4, description = "Запуск сервісів")
    public void startServices() {
        System.out.println("   Усі сервіси запущено.");
    }
}
