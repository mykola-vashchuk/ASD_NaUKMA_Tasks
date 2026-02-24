package PW_7.Task_4;

public class CheckoutService {

    private static final Logger log = LoggerFactory.getLogger();

    public void processCheckout(int orderId, String status, String userToken) {
        if ("SUCCESS".equals(status)) {
            log.info("Checkout successful for order: {}", orderId);
        } else if ("DECLINED".equals(status)) {
            log.warn("Payment declined for order: {}. Check card limits.", orderId);
        } else if ("TIMEOUT".equals(status)) {
            log.error("Gateway timeout during checkout for order: {}. Incident reported.", orderId);
        }
    }
}