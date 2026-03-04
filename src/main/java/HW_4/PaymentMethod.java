package HW_4;

interface PaymentMethod {
    String name();
    boolean pay(int amount);
}