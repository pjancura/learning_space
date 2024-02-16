package java_17.oop_inheritance;

public class ChallengeOne {
    
    public static void main(String[] args) {
        SalariedEmployee salaried = new SalariedEmployee("Jimothy", "02/04/1987", null, "01/01/2020", 80000);
        System.out.println("Jimothy is " + salaried.getAge() + " years old.");
        System.out.println("Is " + salaried.getName() + " retired? " + salaried.getIsRetired());
        System.out.println("Jimothy's paycheck before retiring is " + salaried.collectPay());
        salaried.retire("02/02/2024");
        System.out.println("Is " + salaried.getName() + " retired? " + salaried.getIsRetired());
        System.out.println("Jimothy's paycheck after retiring is " + salaried.collectPay());
       
    }
}

class Worker {

    private String name;
    private String birthDate;
    private String endDate;

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return 2024 - Integer.parseInt(this.birthDate.substring(6));
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }
}

class Employee extends Worker {
    
    private long employeeId;
    private String hireDate;

    private static int employeeNo = 1234567890;

    public Employee(String name, String birthDate, String endDate, String hireDate) {
        super(name, birthDate, endDate);
        this.employeeId = Employee.employeeNo++;
        this.hireDate = hireDate;
    }
}

class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String endDate, String hireDate, double annualSalary) {
        super(name, birthDate, endDate, hireDate);
        this.annualSalary = annualSalary;
    }

    public boolean getIsRetired() {
        return this.isRetired;
    }

    public void retire(String endDate) {
        this.isRetired = true;
        terminate(endDate);
    }

    @Override
    public double collectPay() {
        double rounded = (Math.round((this.annualSalary / 26) * 100));
        double adjusted = (isRetired) ? Math.round(rounded * 0.9) : rounded;
        return  adjusted / 100;
    }
}

class HourlyEmployee extends Employee {
    private double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, String endDate, String hireDate, double hourlyPayRate) {
        super(name, birthDate, endDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay() {
        return this.hourlyPayRate * 2 * 80;
    }

    public void getDoublePay() {
        double doublePay = this.collectPay() * 2;
        System.out.println("Your earned double pay: " + doublePay);
    }

}

