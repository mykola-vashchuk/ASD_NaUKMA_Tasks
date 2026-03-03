package PW_3;

public class MemoryTask {
    public void run() {
        int primitive = 10;
        int[] array = {1, 2, 3};
        Object obj1 = new Object();

        Object obj2 = obj1;

        System.out.println("Primitives reside in the Stack. Objects and arrays reside in the Heap.");
        System.out.println("obj1 and obj2 reference the same memory address.");
    }
}
