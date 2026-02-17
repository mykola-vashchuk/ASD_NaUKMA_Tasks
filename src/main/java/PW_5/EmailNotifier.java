package PW_5;

public interface EmailNotifier {
    default void send(String message){
        System.out.println("Sending email...");
    }
}
