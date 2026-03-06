package PW_3;

public class InitOrderTask {
    public static void main(String[] args) {
        InitOrderTask iot = new InitOrderTask();
        iot.run();
    }

    public void run() {
        new ChildInit();
    }
}
