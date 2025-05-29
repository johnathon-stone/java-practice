//  Part 3. Reference Assignment and Behavior
//   p3.1.1 Create a class with 'String owner and double balance)
public class BankAccount {
    String owner;
    double balance;

//   !* This was not include in the scope of the documentation but required for the program to work *!
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
//   !* This was not included in the scope of the documentation but required for the program to work *!
    public void displayBalance() {
        System.out.printf("Initial balance (%s): $%.2f\n", owner, balance);
    }

//   p3.1.2 Create a method 'deposit(double amount)'.
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Updated Balance (%s): $%.2f", owner, balance);
    }

}
