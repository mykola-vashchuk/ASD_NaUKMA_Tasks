package HW_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentMethodsTest {

    @Test
    public void test_CardPayment_True(){
        PaymentMethod card = new CardPayment();
        int amount = 40000;
        boolean result = card.pay(amount);
        assertTrue(result);
    }

    @Test
    public void test_CardPayment_False(){
        PaymentMethod card = new CardPayment();
        int amount = 80000;
        boolean result = card.pay(amount);
        assertFalse(result);
    }

     @Test
     public void test_PayPalPayment_NotValid() {
         PaymentMethod paypal = new PayPalPayment();
         int amount = 0;
         boolean result = paypal.pay(amount);
         assertFalse(result);
     }
}
