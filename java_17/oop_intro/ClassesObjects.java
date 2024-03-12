// OOP is a way to model real world objects, as software objects, which contain both data and code.
// objects have state - features of the object, that describe the object
// ant (state) -> number of legs, color, age, role in colony
// objects have behavior -> actions that can be performed by the object, or upon the object
// ant (behavior) -> eating, drinking, collecting
// objects store state in field or variables
// objects expose their behavior with methods
// classes are templates for creating objects

// objects are initally assigned the value of NULL
// primitive data types have instrinsic values assigned to them
//      when not explicity stated

// getter and setter methods
//      these allow you to retrieve or set values of a class

// constructor -> used to create an object that is an instance of a class
//      has a specific type of code block that has a specific name and params
//      same name as the class itself
//      never include a return type...not even void
//      should specify an appropriate access modifier, to control who
//          should be able to create new instances of the class
//      if a class does not include a constructor Java implicitely creates one for you

package java_17.oop_intro;


public class ClassesObjects {

    public static void main(String[] args) {
        Car car = new Car();
        Car subaru = new Car();
        // lines 23 - 28 cause erros because the fields are set to private
        // car.make = "Subaru";
        // car.model = "Outback";
        // car.color = "Red";
        // car.doors = 5;
        // car.convertible = false;
        // System.out.println("Make " + car.make);
        subaru.setMake("Subaru");
        subaru.setModel("Outback");
        subaru.setColor("Red");
        subaru.setDoors(5);
        subaru.setConvertible(false);


        car.describeCar();
        subaru.describeCar();
        System.out.println(subaru.getMake());

        // lines 52 - 61 show how to set the values for the fields without a constructor
        // BankAccount account1 = new BankAccount();
        // account1.setAccountNumber(12345);
        // account1.setBalance(1000.00);
        // account1.setCustomerName("Jean Luc");
        // account1.setEmail("jean.luc@mail.com");
        // account1.setPhoneNumber("123-123-1234");
        // account1.printAccountDetails();
        // account1.depositFunds(200);
        // account1.withdrawFunds(2400);
        // account1.withdrawFunds(300);
        BankAccount account = new BankAccount();
        account.printAccountDetails();
        BankAccount account2 = new BankAccount(
                98765, 
                2000.00d, 
                "Henry Ford", 
                "henry.ford@mail.com", 
                "098-098-0987");
        account2.printAccountDetails();
        account2.depositFunds(3000d);
        account2.withdrawFunds(5000d);
        account2.withdrawFunds(200d);

        Customer customer1 = new Customer("Hank", 4000.00, "hank.hill@mail.com");
        System.out.println(customer1.getName() + " " + customer1.getEmail() + " \nCredit Limit: " + customer1.getCreditLimit());

        Customer customer2 = new Customer();
        System.out.println(customer2.getName() + " " + customer2.getEmail() + " \nCredit Limit: " + customer2.getCreditLimit());

        Customer customer3 = new Customer("Peggy", "peggy.hill@mail.com");
        System.out.println(customer3.getName() + " " + customer3.getEmail() + " \nCredit Limit: " + customer3.getCreditLimit());

    }

    public class SimpleCalculator {
        // write code here
        private double firstNumber;
        private double secondNumber;
        
        public double getFirstNumber() {
            return firstNumber;
        }
        public double getSecondNumber() {
            return secondNumber;
        }

        public void setFirstNumber(double firstNumber) {
            this.firstNumber = firstNumber;
        }
        public void setSecondNumber(double secondNumber) {
            this.secondNumber = secondNumber;
        }

        public double getAdditionResult() {
            return this.firstNumber + this.secondNumber;
        }

        public double getSubtractionResult() {
            return this.firstNumber - this.secondNumber;
        }

        public double getMultiplicationResult() {
            return this.firstNumber * this.secondNumber;
        }

        public double getDivisionResult() {
            if (this.secondNumber == 0) {
                return 0;
            }
            return this.firstNumber / this.secondNumber;
        }       
    }

    public class Person {
        // write code here
        private String firstName;
        private String lastName;
        private int age;

        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public int getAge() {
            return age;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setAge(int age) {
            if (age < 0 || age > 100) {
                this.age = 0;
            } else {
                this.age = age;
            }
        }

        public boolean isTeen() {
            if (this.age > 12 && this.age < 20) {
                return true;
            }
            return false;
        }

        public String getFullName() {
            if (this.firstName.isEmpty() && this.lastName.isEmpty()) {
                return "";
            } else if (this.firstName.isEmpty()) {
                return this.lastName;
            } else if (this.lastName.isEmpty()) {
                return this.firstName;
            } else {
                return this.firstName + " " + this.lastName;
            }
        }
    }

}