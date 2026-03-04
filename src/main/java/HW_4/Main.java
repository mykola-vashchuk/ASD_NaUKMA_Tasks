package HW_4;

public class Main {

    public static void main(String[] args) {
        //===Task 1-2===
        PaymentService service = new PaymentService();

        PaymentMethod crypto = new CryptoPayment();
        PaymentMethod card = new CardPayment();
        PaymentMethod paypal = new PayPalPayment();

        System.out.println("");

        //card payment simulation
        System.out.println("card.pay(10000) = "+card.pay(10000));
        System.out.println("card.pay(60000) = "+card.pay(60000));
        //paypal payment simulation
        System.out.println("paypal.pay(1) = "+paypal.pay(1));
        System.out.println("paypal.pay(20) = "+paypal.pay(20));
        //crypti payment simulation
        System.out.println("crypto.pay(14) = "+crypto.pay(14));
        System.out.println("crypto.pay(140) = "+crypto.pay(140));

        //===Task 3===
        System.out.println("");
        BaseNotifier n = new EmailNotifier();
        n.notifyUser("Hello");

        //===Task 4===
        System.out.println("");
        doRefund(card);
        doRefund(paypal);
    }

    static void doRefund(PaymentMethod method) {
        if(method instanceof CardPayment){
            CardPayment cardPayment = (CardPayment) method;
            System.out.println(cardPayment.refund());

        }else{
            System.out.println("Refund cannot be done to anything, yet Card!");
        }
    }
}
