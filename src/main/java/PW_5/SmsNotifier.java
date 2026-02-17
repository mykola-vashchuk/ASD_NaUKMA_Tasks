package PW_5;

public interface SmsNotifier {
    default void send(String message){
        System.out.println("Sending sms...");
    }
}
