package PW_7.Task_4;

public interface Logger {
    void info(String message, Object... args);
    void warn(String message, Object... args);
    void error(String message, Object... args);
}