package HW_2;

import java.util.Arrays;

public class VendingMachine {
    private Product[] products;
    private double balance;

    public VendingMachine(Product[] products) {
        if(products == null){
            this.products = new Product[0];
        }else{
            this.products = Arrays.copyOf(products, products.length);
        }
    }

    public String[] getProductNames(){
        String[] names = new String[products.length];
        for(int i = 0; i < products.length; i++){
            names[i] = products[i].getName();
        }
        return names;
    }

    public void insertMoney(double amount){
        if(amount >= 0){
            this.balance += amount;
        }else {
            System.out.println("Amount must be positive!");
        }
    }

    public Product selectProduct(int id){
        for(Product product : products){
            if(product.getId() == id){
                if(this.balance >= product.getPrice()){
                    this.balance -= product.getPrice();
                    return product;
                }else{
                    System.out.println("Not enough money(((");
                    return null;
                }
            }
        }
        return null;
    }

    public double getChange(){
        double change = this.balance;
        this.balance = 0;
        return change;
    }

}
