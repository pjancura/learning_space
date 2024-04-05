package java_17.strings;

public class TextBlockAndFormat {
    
    public static void main(String[] args) {
        
        String bulletIt = "Print a Bulleted List: \n" +
                    "\t\u2022 First Point\n" +
                    "\t\t\u2022 Sub Point";

        System.out.println(bulletIt);

        String textBlock = """
                Print a Bulleted List:
                        \u2022 First Point
                            \u2022 Sub Point  
                """;

        System.out.println(textBlock);

        int age = 35;
        System.out.printf("Your age is %d%n", age);

        int yearOfBirth = 2024 - age;
        System.out.printf("You were born in the year %.2f%n", (float) yearOfBirth);

        for (int i = 1; i <= 10000; i *= 10) {
            // the 6 in %6d mean that all of the numbers will take up 6 spaces 
            // the numbers printed will be right aligned now
            System.out.printf("Printing %6d %n", i);
        }

        String formattedString = String.format("Your age is %d%n", age);
        System.out.println(formattedString);

        formattedString = "Your age is %d%n".formatted(age);
        System.out.println(formattedString);
    }
}
