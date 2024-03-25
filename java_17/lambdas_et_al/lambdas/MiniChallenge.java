package java_17.lambdas_et_al.lambdas;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiniChallenge {
    
    public static void main(String[] args) {
        String str = "the dog bit the big brown bear.";

        Consumer<String> partsPrinter = (String sentence) -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach((part) -> System.out.println(part));
        };

        partsPrinter.accept(str);

        Consumer<String> partsPrinterConcise = (String sentence) -> Arrays.asList(sentence.split(" ")).forEach((word) -> System.out.println(word));

        partsPrinterConcise.accept(str);

        Function<String, String> everySecondChar = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        UnaryOperator<String> everySecondChar2 = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        String nums = "1234567890";

        printEverySecondChar(nums, everySecondChar2);

        Supplier<String> iLoveJava = () -> {
            return "I Love Java!";
        };

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
        
    }

    public static void printEverySecondChar(String source, Function<String, String> function) {
        String everySecondChar = function.apply(source);
        System.out.println(everySecondChar);
    }
}
