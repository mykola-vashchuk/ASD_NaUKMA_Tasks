package PW_5;

class CardPayment implements PaymentMethod{
    @Override
    public String name() {return "Card Payment";}

    @Override
    public boolean pay(int amount){ return amount > 0 && amount <= 100_000; }
}
