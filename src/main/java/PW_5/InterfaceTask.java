package PW_5;

public class InterfaceTask {
    public static void main(String[] args) {
        run();
        PaymentMethod card = new CardPayment();
        card.payWithFee(100,500);
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
        card.payWithFee(100,500);//платіж з штрафом
        PaymentProcessor processor = new PaymentProcessor();
        int amount = 150;

        for (PaymentMethod m : methods) {
            boolean okay = processor.process(m, amount);
            System.out.println(m.name() + ": " + okay);
        }

    }
}
