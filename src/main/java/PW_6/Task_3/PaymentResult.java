package PW_6.Task_3;

public class PaymentResult {
    private final boolean success;
    private final String message;

    private PaymentResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static PaymentResult ok() {return new PaymentResult(true, "OK");}

    public static PaymentResult fail(String message) {return new PaymentResult(false, message);}

    public boolean isSuccess() {return success;}

    public String message() {return message;}

    @Override
    public String toString() {return success ? "OK" : "FAIL: " + message;}
}