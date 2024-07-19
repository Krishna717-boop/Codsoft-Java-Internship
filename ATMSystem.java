import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Successfully deposited $" + String.format("%.2f", amount) + ". New balance: $"
                    + String.format("%.2f", balance);
        } else {
            return "Deposit amount must be positive.";
        }
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return "Successfully withdrew $" + String.format("%.2f", amount) + ". New balance: $"
                    + String.format("%.2f", balance);
        } else if (amount > balance) {
            return "Insufficient balance for this withdrawal.";
        } else {
            return "Withdrawal amount must be positive.";
        }
    }

    public String checkBalance() {
        return "Current balance: $" + String.format("%.2f", balance);
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(account.deposit(depositAmount));
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(account.withdraw(withdrawAmount));
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0); // Starting with an initial balance of $100
        ATM atm = new ATM(account);
        atm.run();
    }
}
