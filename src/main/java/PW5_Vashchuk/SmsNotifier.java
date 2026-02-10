package PW5_Vashchuk;

public interface SmsNotifier {
    default void send(String message){
        System.out.println("Sending sms...");
    }
}
