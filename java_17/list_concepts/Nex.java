package java_17.list_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Nex {
    
    public static void main(String[] args) {
        
        String[] originalArray = new String[] {"First", "Second", "third"};
        var originalList = Arrays.asList(originalArray);

        originalList.set(0, "one");
        System.out.println("List: " + originalList);
        System.out.println("array: " + Arrays.toString(originalArray));

        originalList.sort(Comparator.naturalOrder());
        System.out.println("array: " + Arrays.toString(originalArray));

        // originalList.add("fourth");    // doesn't work because the size of the array can't be changed

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);

        ArrayList<String> stringLists = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
        String[] stringArray = stringLists.toArray(new String[0]);

        System.out.println(Arrays.toString(stringArray));


    }
}
