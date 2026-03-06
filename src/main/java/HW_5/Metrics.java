package HW_5;

public interface Metrics {
        void record(String event);
        default void recordError(String message) {
            System.out.println("[ERROR] -" + message);
        }
        static boolean isValidEvent(String event) {
            return event != null && !event.trim().isEmpty();
        }
}
