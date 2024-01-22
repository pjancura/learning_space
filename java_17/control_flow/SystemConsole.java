package java_17.control_flow;

public class SystemConsole {

    public static void main(String[] args) {
        int currentYear = 2024;
        String usersDateOfBirth = "1999";

        System.out.println("Age = " + (currentYear - Integer.parseInt(usersDateOfBirth)));


        System.out.println(getInputFromConsole(currentYear));
        System.out.println(getInputFromScanner(currentYear));
    }

    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("Hi, What's your Name? \n");
        System.out.println("Hi " + name + ", Thanks for taking the course!");
        String dateOfBirth = System.console().readLine("What year were you born? \n");
        int age = currentYear - Integer.parseInt(dateOfBirth);
        return "You are " + String.valueOf(age) + " years old";
    }

    public static String getInputFromScanner(int currentYear) {
        return "";
    }
}