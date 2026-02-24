package PW_7.Task_3;

public class ReceiptGenerationException extends RuntimeException {
    public ReceiptGenerationException(String message) {
        super(message);
    }
    public ReceiptGenerationException(String message, Throwable cause) { super(message, cause); }
}
