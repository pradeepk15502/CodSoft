import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Deposit amount must be positive.";
        }
        balance += amount;
        return "Deposited " + amount + ". New balance is " + balance + ".";
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Withdrawal amount must be positive.";
        }
        if (amount > balance) {
            return "Insufficient funds.";
        }
        balance -= amount;
        return "Withdrew " + amount + ". New balance is " + balance + ".";
    }

    public String checkBalance() {
        return "Your current balance is " + balance + ".";
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public String withdraw(double amount) {
        return bankAccount.withdraw(amount);
    }

    public String deposit(double amount) {
        return bankAccount.deposit(amount);
    }

    public String checkBalance() {
        return bankAccount.checkBalance();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayOptions();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(withdraw(withdrawAmount));
                    scanner.nextLine();  // Consume newline
                    break;
                case "2":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(deposit(depositAmount));
                    scanner.nextLine();  // Consume newline
                    break;
                case "3":
                    System.out.println(checkBalance());
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);  // Initial balance of 100
        ATM atm = new ATM(account);
        atm.run();
    }
}
