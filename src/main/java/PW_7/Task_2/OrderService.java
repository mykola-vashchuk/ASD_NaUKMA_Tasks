package PW_7.Task_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {
    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void checkout(int orderId, String userEmail){
        try{
            ProcessFakePayment();
        }catch(PaymentGatewayException e){
            logger.error("Payment failed for order {}, email {}",orderId, userEmail, e);
            throw new OrderProcessingException("Checkout failed for order: " + orderId, e);
        }

    }

    private void ProcessFakePayment() throws PaymentGatewayException{
        throw new PaymentGatewayException("Payment failed.");
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        OrderService.logger = logger;
    }
}
