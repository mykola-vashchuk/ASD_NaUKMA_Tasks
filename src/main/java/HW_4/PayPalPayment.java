package HW_4;

import java.lang.annotation.Inherited;

public class PayPalPayment implements PaymentMethod{
    @Override
    public String name(){
        return "PayPal payment";
    }
    @Override
    public boolean pay(int amount){
        return amount > 10;
    }
}
