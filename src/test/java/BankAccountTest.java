import PW_2.BankAccount;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    @Test
    void depositShouldIncreaseBalance() {
        BankAccount raccoon = new BankAccount("666JOKER666",500);
        System.out.println("Balance is: "+raccoon.getBalance());
        raccoon.deposit(350);
        System.out.println("Balance is: "+raccoon.getBalance());
    }
}