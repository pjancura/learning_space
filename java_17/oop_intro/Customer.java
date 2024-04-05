package java_17.oop_intro;

public class Customer {
    private String name;
    private double creditLimit;
    private String email;

    public Customer() {
        this("Bobby", "bobby.hill@mail.com");
    }

    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public Customer(String name, String email) {
        this(name, 5.00, email);
    }

     

    public void setName(String name) {
        this.name = name;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public double getCreditLimit() {
        return creditLimit;
    }
    public String getEmail() {
        return email;
    }
}
