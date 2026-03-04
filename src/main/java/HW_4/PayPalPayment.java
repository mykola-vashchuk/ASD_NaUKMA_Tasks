package HW_4;

import java.lang.annotation.Inherited;

public class PayPalPayment implements PaymentMethod{
    @Override
    public String name(){
        return "PayPal payment";
    }
    @Override
    public boolean pay(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("AAmount must be grater than 0!");
        }
        return amount >= 10;
    }
}
