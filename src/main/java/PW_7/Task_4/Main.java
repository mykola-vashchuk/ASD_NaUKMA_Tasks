package PW_7.Task_4;

public class Main {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();

        service.processCheckout(1, "SUCCESS", "secret_token_abc123");
        service.processCheckout(2, "DECLINED", "secret_token_def456");
        service.processCheckout(3, "TIMEOUT", "secret_token_ghi789");
    }
}