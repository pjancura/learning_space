package java_17.strings;

// stringBuilder makes a string object where the text is mutable
// to the constructor you can pass a:
//      string
//      no arguments at all
//      an integer value
//      some other type of character sequence (Like StringBuilder)



public class StringBuilderExample {
    
    public static void main(String[] args) {
        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and Goodbye");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(17));
        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(57));

        // other methods
        // delete()
        // deleteAt()
        // insert()
        // reverse()
        // setLength()

        printInformation(emptyStart);
        printInformation(emptyStart32);

    }

    public static void printInformation(String string) {
        System.out.println(("String = " + string));
        System.out.println("length = " + string.length());
    }

    public static void printInformation(StringBuilder builder) {
        System.out.println(("StringBuilder = " + builder));
        System.out.println("length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
    }
}
