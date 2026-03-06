package PW_3;

public class BaseInit {
    static {
        System.out.println("BaseInit static block");
    }

    {
        System.out.println("BaseInit instance block");
    }

    BaseInit() {
        System.out.println("BaseInit constructor");
    }
}
