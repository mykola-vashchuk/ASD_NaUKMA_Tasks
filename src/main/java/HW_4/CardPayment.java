package HW_4;

public class CardPayment implements PaymentMethod{
    @Override
    public String name(){
        return "Card payment";
    }
    @Override
    public boolean pay(int amount){
        return amount <= 50000 && amount > 0;
    }
    public String refund(){
        return "Card refund.";
    }
}
