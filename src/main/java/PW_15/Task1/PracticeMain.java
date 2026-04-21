package PW_15.Task1;

import PW_15.Task2.PaymentService;
import PW_15.Task2.ServiceFactory;
import PW_15.Task3.SetupFlow;
import PW_15.Task3.StepRunner;

public class PracticeMain {
    public static void main(String[] args) {
        //Завдання 1
        System.out.println("\n===== Завдання 1 =====");
        ClassInfoPrinter.print(Book.class);

        // Завдання 2
        System.out.println("\n===== Завдання 2 =====");
        PaymentService card = ServiceFactory.create("PW_15.Task2.CardPaymentService");
        card.pay("Вадім Дудар", 1500.00);

        PaymentService cash = ServiceFactory.create("PW_15.Task2.CashPaymentService");
        cash.pay("Максим Демків", 250.50);

        // Завдання 3
        System.out.println("\n===== Завдання 3 =====");
        StepRunner.run(new SetupFlow());
    }
}
