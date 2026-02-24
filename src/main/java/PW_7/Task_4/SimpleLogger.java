package PW_7.Task_4;

public class SimpleLogger implements Logger {

    private String formatMessage(String message, Object... args) {
        String formatted = message;
        if (args != null) {
            for (Object arg : args) {
                String replacement = (arg != null) ? arg.toString() : "null";
                formatted = formatted.replaceFirst("\\{\\}", replacement);
            }
        }
        return formatted;
    }

    @Override
    public void info(String message, Object... args) {
        System.out.println("[INFO] " + formatMessage(message, args));
    }

    @Override
    public void warn(String message, Object... args) {
        System.out.println("[WARN] " + formatMessage(message, args));
    }

    @Override
    public void error(String message, Object... args) {
        System.err.println("[ERROR] " + formatMessage(message, args));
    }
}