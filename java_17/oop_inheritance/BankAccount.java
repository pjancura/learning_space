package java_17.oop_inheritance;

public class BankAccount {
    private int accountNumber = 0;
    private double balance = 0.00;
    private String customerName = "";
    private String email = "";
    private String phoneNumber = "";

    public BankAccount() {
        this(034417, 5.00, "Default Name",
                    "default@mail.com", "567-1DE-FAULT");
        System.out.println("Constructor with defaults");
    }

    public BankAccount(int accountNumber, double balance, String customerName, String email, String phoneNumber) {
        System.out.println("BankAccount Constructor called");
        this.accountNumber = accountNumber;
        this.setBalance(balance);
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    

    // getters
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setters
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // method to print account details
    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber +
                "\nBalance: " + balance +
                "\nCustomer Name: " + customerName +
                "\nEmail: " + email +
                "\nPhone Number: " + phoneNumber);
    }
    // method for withdraw cash
    public void depositFunds(double amount) {
        this.setBalance(this.getBalance() + amount);
        System.out.println("New Balance: " + this.getBalance());
    }

    // method to deposit cash
    public void withdrawFunds(double amount) {
        if (this.getBalance() - amount < 0) {
            System.out.println("Insufficient funds. Current Balance: " + this.balance);
        } else {
            this.setBalance((this.getBalance() - amount));
            System.out.println("New Balance: " + this.getBalance());
        }
    }
}
