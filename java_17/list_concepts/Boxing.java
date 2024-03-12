//  going from a primitive to a wrapper, which is called boxing, 
//      or wrapper to a primitive, which is called unboxing
// Boxing exists b/c primitive data types are not supported when using Lists (LinkedLists, etc)

package java_17.list_concepts;

import java.util.ArrayList;
import java.util.Arrays;

public class Boxing {
    
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(15);     // preferred but unnecessary
        Integer deprecatedBoxing = new Integer(15);     // deprecated since JDK 9
        int unboxedInt = boxedInt.intValue();                   // unnecessary

        // Automatic Boxing and Unboxing
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
        // System.out.println(autoUnboxed.getClass().); // create compiler error because primitives do not have classes

        Double resultBoxed = getLliteralDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));

        var ourList = getList(1, 2, 3, 4, 5);
        System.out.println(ourList);

    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getLliteralDoublePrimitive() {
        return 100.00;
    }

    // this method unboxes an Integer to int
    private static int returnAnInt(Integer i) {
        return i;
    }

    // this method boxes an int to Integer
    private static Integer returnAnInteger(int i) {
        return i;
    }

    
    private static ArrayList<Integer> getList(Integer... varargs) {
        ArrayList<Integer> aList = new ArrayList<>();
        for( int i : varargs) {
            aList.add(i);
        }
        return aList;
    }


}
