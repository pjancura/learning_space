package java_17.strings;

// there are inspection methods, comparing string values, and manipulation methods

public class StringMethods {
 
    public static void main(String[] args) {
        
        printInformation("Hello World");
        printInformation("");
        printInformation("\t      \n");

        String helloWorld = "Hello World";
        System.out.printf("index of r = %d %n", helloWorld.indexOf('r'));
        System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));

        System.out.printf("index of first l = %d %n", helloWorld.indexOf('l'));
        System.out.printf("index of last l = %d %n", helloWorld.lastIndexOf('l'));

        // this indexOf looks forward from the index
        System.out.printf("index of second l = %d %n", helloWorld.indexOf('l', 3));
        // lastIndexOf looks backwards from the index
        System.out.printf("index of second l = %d %n", helloWorld.lastIndexOf('l', 8));

        String helloWorldLower = helloWorld.toLowerCase();

        if (helloWorld.equals(helloWorldLower)) {
            System.out.println("Values match exactly");
        }

        if (helloWorld.equalsIgnoreCase(helloWorldLower)) {
            System.out.println("Values match ignoring case");
        }

        if (helloWorld.startsWith("Hello")) {
            System.out.println("String starts with Hello");
        }

        if (helloWorld.endsWith("World")) {
            System.out.println("String ends with World");
        }

        if (helloWorld.contains("World")) {
            System.out.println("String contains World");
        }

        if (helloWorld.contentEquals("Hello World")) {
            System.out.println("Content Equals Hello World");
        }
    }

    public static void printInformation(String string) {
        
        int length = string.length();
        System.out.printf("Length = %d %n", length);
        if (string.isEmpty()) {
            System.out.println("String is Empty");
            return;
        }

        if (string.isBlank()) {
            System.out.println("String is Blank");
            
        }
        System.out.printf("first char = %c %n", string.charAt(0));
        System.out.printf("Last char = %c %n", string.charAt(length -1));
    }
}
