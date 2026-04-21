package PW_15.Task2;

public class CardPaymentService implements PaymentService{
    @Override
    public void pay(String recipient, double amount) {
        System.out.printf("Картка: оплата %.2f грн -> [%s]%n", amount, recipient);
    }
}
