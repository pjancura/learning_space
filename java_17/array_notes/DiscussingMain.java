package java_17.array_notes;

public class DiscussingMain {
    
    // this "..." with create an array out of strings that used as parameters
    public static void main(String... args) {
        
        System.out.println("Hello World again");

        String[] splitStrings = "Hello World again".split(" ");

        printText(splitStrings);

        System.out.println("_".repeat(20));
        printText("Hello", "World", "separated");

        // varargs ....  there can only be one variable argument in a method
        // varargs ....  the argument must be the last argument

        String[] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(", ", sArray));
    }

    private static void printText(String... textList) {
        for (String t : textList) {
            System.out.println(t);
        }
    }
}
