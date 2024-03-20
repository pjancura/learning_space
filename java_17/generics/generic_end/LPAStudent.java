package java_17.generics.generic_end;

import java.util.List;

public class LPAStudent extends Student {
    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return ("%s %8.1f%%".formatted(super.toString(), this.percentComplete));
    }

    public double getPercentComplete() {
        return this.percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return this.getPercentComplete() <= (Double.parseDouble(value));
        }
        return super.matchFieldValue(fieldName, value);
    }
}
