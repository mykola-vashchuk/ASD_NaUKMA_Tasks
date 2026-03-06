package PW_3;

public class ChildInit extends BaseInit {
    static {
        System.out.println("ChildInit static block");
    }

    {
        System.out.println("ChildInit instance block");
    }

    ChildInit() {
        System.out.println("ChildInit constructor");
    }
}
