package PW5_Vashchuk;

public class InterfaceTask {
    public static void main(String[] args) {
        run();
        MultiNotifier M = new MultiNotifier();
        M.send("Hello World!");
        DailyReport d = new DailyReport();
        d.fetchData();
        d.format();
    }

    static void run() {
        PaymentMethod[] methods = {new CardPayment(), new PayPalPayment()};


        PaymentProcessor processor = new PaymentProcessor();
        int amount = 15;

        for (PaymentMethod m : methods) {
            boolean okay = processor.process(m, amount);
            System.out.println(m.name() + ": " + okay);
        }
    }
}
