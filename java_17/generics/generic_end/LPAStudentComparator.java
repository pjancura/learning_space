package java_17.generics.generic_end;

import java.util.Comparator;

public class LPAStudentComparator implements Comparator<LPAStudent> {

    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        int result = (int) (o1.getPercentComplete() - o2.getPercentComplete());
        System.out.println("Comparing: " + "%.2f".formatted(o1.getPercentComplete()) + "\t" + "%.2f".formatted(o2.getPercentComplete()) + "\t" + "result: " + result);
        return result;
    }
    
}
