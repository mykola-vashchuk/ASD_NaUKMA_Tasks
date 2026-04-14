package PW_13.Task2;

public class UnsafeInventory implements Inventory{
    private int amount;

    public UnsafeInventory(int amount){
        this.amount = amount;
    }

    @Override
    public void reserve(int amt){
        if(amount >= amt) {
            Thread.yield(); // to intentionally increase chance of race condition
            amount -= amt;
        }
    }

    @Override
    public int available(){
        return amount;
    }
}
