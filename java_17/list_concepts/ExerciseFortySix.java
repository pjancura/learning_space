package java_17.list_concepts;

import java.util.ArrayList;

public class ExerciseFortySix {

    public static void main(String[] args) {
        Bank banky = new Bank("Banky");
        System.out.println(banky);
        System.out.println(banky.addBranch("Branch1"));
        System.out.println("Adding repeat branch: " + banky.addBranch("Branch1"));
        System.out.println(banky.addCustomer("Branch1", "Paul",500));
        System.out.println("Adding repeat Customer: " + banky.addCustomer("Branch1", "Paul",500));
        banky.listCustomers("Branch1", false);
    }
}

class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>(100);
    }

    private Branch findBranch(String nameBranch) {
        for (Branch branch : this.branches) {
            if (branch.getName() == nameBranch) {
                return branch;
            }
        }
        return null;
    }

    public boolean addBranch(String brName) {
        // Branch branch = this.findBranch(brName);
        if (this.findBranch(brName) == null) {
            this.branches.add(new Branch(brName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String brName, String cusName, double initialDeposit) {
        Branch branch = this.findBranch(brName);
        if (branch != null) {
                return branch.newCustomer(cusName, initialDeposit);
        }
        return false;
    }

    public boolean addCustomerTransaction(String brName, String cusName, double amount) {
        Branch branch = this.findBranch(brName);
        if (branch != null) {
            return branch.addCustomerTransaction(cusName, amount);
        }
        return false;
    }

    public boolean listCustomers(String brName, boolean boo) {
        Branch branch = this.findBranch(brName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> customers = branch.getCustomers();
            for (Customer customer : customers) {
                System.out.println("Customer: " + customer.getName() + "[" + (customers.indexOf(customer) + 1) + "]");
                if (boo) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (double transaction : transactions) {
                        System.out.println("[" + (transactions.indexOf(transaction) + 1) + "] Amount " + transaction);
                    }
                }
            }
            return true;
        }
        return false;
    }
}

class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>(100);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public boolean newCustomer(String name, double initialDeposit) {
        for (Customer customer : this.customers) {
            if (customer.getName() == name) {
                return false;
            }
        }
        this.customers.add(new Customer(name, initialDeposit));
        return true;
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName() == name) {
                return customer;
            }
        }
        return null;
    }

    public boolean addCustomerTransaction(String name, double amount) {
        Customer customer = this.findCustomer(name);
        if (customer != null) {
            customer.addTransaction(amount);
            return true;
        }
        return false;
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
    
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

}