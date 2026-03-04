package HW_4;

public class CryptoPayment implements PaymentMethod{
    @Override
    public String name(){
        return "Crypto payment";
    }
    @Override
    public boolean pay(int amount){
        return amount%5 == 0;
    }
}
