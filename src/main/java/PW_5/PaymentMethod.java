package PW_5;

interface PaymentMethod {
    String name();
    boolean pay (int amount);

    default void payWithFee(int amount, int fee) {pay(amount+fee);}

    static boolean isValidAmount(int amount) {return amount > 0;}
}
