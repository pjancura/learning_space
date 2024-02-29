package java_17.list_concepts;

import java.util.ArrayList;

public class BoxingChallenge {
    
    public static void main(String[] args) {
        Customer customer = new Customer("Paul", 500.00);
        customer.credit(4.00);
        customer.credit(5.00);
        customer.debit(8.00);
        customer.printTransactionHistory(); 

        Bank bank = new Bank("Banky");
        bank.addCustomer(customer);
        bank.addCustomer(customer);
        bank.printCustomers();
        bank.addTransaction("Paul", -10.00);
        bank.addTransaction("Paul", 15.00);
        bank.printCustomerInfo("Paul");
        bank.addCustomer("George", 25.00);
        bank.printCustomers();
    }


}

class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.bankName = name;
        this.customers = new ArrayList<Customer>(100);
    }

    public void addCustomer(String name, double initialDeposit) {
        if (this.findCustomer(name)) {
            System.out.println("Customer already exists");
        } else {
            Customer customer = new Customer(name, initialDeposit);
            this.customers.add(customer);
            System.out.println(customer.getName() + " was added to " + this.bankName);
        }
    }

    public void addCustomer(Customer customer) {
        if (this.findCustomer(customer.getName())) {
            System.out.println("Customer already exists");
        } else {
            this.customers.add(customer);
            System.out.println(customer.getName() + " was added to " + this.bankName);
        }
    }

    public boolean findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName() == name) {
                return true;
            }
        }
        return false;
    }

    private int customerIndex(String name) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getName() == name) {
                return i;
            }
        }
        return -1;
    }

    public void addTransaction(String name, Double amount) {
        int index = this.customerIndex(name);
        if (index != -1) {
            if (amount >= 0) {
                this.customers.get(index).credit(amount);
            } else {
                this.customers.get(index).debit(amount);
            }
        } else {
            System.out.println("This customer doens't exist, try another name");
        }
    }

    public void printCustomerInfo(String name) {
        int index = this.customerIndex(name);
        this.customers.get(index).printTransactionHistory();
    }

    public void printCustomers() {
        for (Customer customer : this.customers) {
            System.out.println(customer.getName());
        }
    }
    
}

class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialDeposit) {
        this.name = name;
        this.transactions = new ArrayList<Double>(500);
        this.transactions.add(initialDeposit);
    }

    public void credit(Double amount) {
        Double changed = amount;
        if (amount < 0.00) {
            changed = -amount;
        }
        this.transactions.add(changed);
    }

    public void debit(Double amount) {
        Double changed = amount;
        if (amount >= 0.00) {
            changed = -amount;
        }
        this.transactions.add(changed);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void printTransactionHistory() {
        System.out.println("CUSTOMER: " + this.getName());
        System.out.println("TRANSACTIONS\n--------------");
        Double balance = 0.00;
        for (Double amount : transactions) {
            System.out.printf("%13.2f%n", amount);
            balance += amount;
        }
        System.out.println("--------------\nBALANCE: " + balance);
    }
}
