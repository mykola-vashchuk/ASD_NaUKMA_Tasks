package PW_5;

public class PayPalPayment implements PaymentMethod {
    @Override
    public String name() {return "PayPal Payment";}

    @Override
    public boolean pay(int amount){ return amount > 100; }
}

