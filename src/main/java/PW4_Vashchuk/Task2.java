package PW4_Vashchuk;
class Task2 {
    public static void main(String[] args) {
        A a = new B();
        a.process("hi");
    }

    static class A {
        void process(Object o) {
            System.out.println("A:Process Object");
        }
    }

    static class B extends A {
        @Override
        void process(Object o) {
            System.out.println("B:Override Object");
        }

        void process(String s) {
            System.out.println("B:Ovearload String");
        }
    }
}