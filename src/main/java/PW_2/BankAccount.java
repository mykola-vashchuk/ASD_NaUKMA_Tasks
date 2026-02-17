package PW_2;


public class BankAccount {

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance){
        if (accountNumber == null || accountNumber.isEmpty())
            throw new IllegalArgumentException("Account number cannot be null!");
        this.accountNumber = accountNumber;

        if(initialBalance<0){
            System.out.println("Balance cannot be negative! Set to 0.");
            this.balance = 0;
        }else
            this.balance = initialBalance;

    }

    public String getAccountNumber(){ return accountNumber; }

    public double getBalance() { return balance; }

    public void deposit(double amount){
        if(amount < 0)
            System.out.println("Eror: Cannot enter negative amount: " + amount);
        else
            balance += amount;
        System.out.println("Successfully top up the account on "+amount+". Current balance: "+balance);
    }

    public void withdraw(double amount){
        if(amount < 0 || amount > balance)
            System.out.println("Enter valid number"+"Your balance: "+balance);
        else
            balance -= amount;
        System.out.println("Succeed! Your balance "+balance);
    }
}

