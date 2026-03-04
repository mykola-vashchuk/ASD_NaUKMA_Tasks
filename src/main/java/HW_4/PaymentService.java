package HW_4;

public class PaymentService {

    boolean process(PaymentMethod method, int amount){
        System.out.println("Method: "+method.name()+", Amount: "+amount);
        return method.pay(amount);
    }

}
