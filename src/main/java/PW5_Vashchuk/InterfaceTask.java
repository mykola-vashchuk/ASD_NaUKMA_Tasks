package PW5_Vashchuk;

public class InterfaceTask {
    public static void main(String[] args) {
        run();
        //2 Завдання
        DailyReport d = new DailyReport();
        d.fetchData();
        d.format();
        //3 Завдання
        MultiNotifier M = new MultiNotifier();
        M.send("Hello World!");
    }

    static void run() {
        PaymentMethod[] methods = {new CardPayment(), new PayPalPayment()};
        PaymentMethod card = new CardPayment();
        card.payWithFee(100,500);
        PaymentProcessor processor = new PaymentProcessor();
        int amount = 15;

        for (PaymentMethod m : methods) {
            boolean okay = processor.process(m, amount);
            System.out.println(m.name() + ": " + okay);
        }

    }
}
