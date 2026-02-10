package PW5_Vashchuk;

interface PaymentMethod {
    String name();
    boolean pay (int amount);

    default boolean payWithFee(int amount, int fee) {return pay(amount+fee);}

    static boolean isValidAmount(int amount) {return amount > 0;}
}
