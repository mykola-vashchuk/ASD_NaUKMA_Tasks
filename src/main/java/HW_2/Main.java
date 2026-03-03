package HW_2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Apple", 25),
                new Product(2, "Watermelon", 40),
                new Product(3, "Banana", 35)
        };

        VendingMachine machine = new VendingMachine(products);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available products: " + Arrays.toString(machine.getProductNames()));

        while(true){
            System.out.println("\nChoose an action | 1 - Insert money | 2 - Select product | 3 - Change and Exit");
            int choice = scanner.nextInt();

            if(choice == 1){
                System.out.println("\nEnter amount to insert: ");
                machine.insertMoney(scanner.nextDouble());
                System.out.println("Money inserted.");
            }else if(choice == 2){
                System.out.println("\nEnter product ID");
                Product p = machine.selectProduct(scanner.nextInt());
                if(p != null){
                    System.out.println("Your product: "+ p.getName());
                }
            }else if (choice == 3){
                System.out.println("Here's your change: " + machine.getChange());
                break;
            }else{
                System.out.println("Invalid choice! Please enter 1, 2 or 3.");
            }
        }
        scanner.close();
    }
}
