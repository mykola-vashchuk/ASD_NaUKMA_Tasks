package PW_15.Task2;

public class CashPaymentService implements PaymentService{
    public void pay(String recipient, double amount) {
        System.out.printf("Готівка: оплата %.2f грн -> [%s]%n", amount, recipient);
    }
}
