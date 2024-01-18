package java_17.expressions_statements_methods;

public class StatementsAndCodeOrganization {

    public static void main(String[] args) {
        int myVariable = 50;                    // this is a single Java statement
        myVariable++;
        myVariable--;                           // these are also statements in Java
        
        System.out.println("This is a test");      // the semicolon denotes a single statement in Java

        int anotherVariable = 50; myVariable--; System.out.println(("myVariable = " + myVariable));  //this is single line of 3 statements, maybe not the most readable, but it is valied to the compiler

        if (myVariable == 0) {
            System.out.println(anotherVariable);
        }

    }
}