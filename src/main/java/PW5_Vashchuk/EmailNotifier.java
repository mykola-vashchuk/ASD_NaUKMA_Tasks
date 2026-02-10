package PW5_Vashchuk;

public interface EmailNotifier {
    default void send(String message){
        System.out.println("Sending email...");
    }
}
