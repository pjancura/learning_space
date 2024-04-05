package java_17.oop_inheritance;

public class ThisAndSuper {

    public static void main(String[] args) {
        
    }
    
}

class ThisDetails {
    private int number;
    private int year;
    private int month;
    private int day;

    public ThisDetails() {
        this(02, 06);
    }

    public ThisDetails(int month, int day) {
        this(420, 2024, month, day);
    }

    public ThisDetails(int number, int year, int month, int day) {
        this.number = number;
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class SuperDetails extends ThisDetails {

    private boolean isSuper;

    public SuperDetails(boolean isSuper) {
        this(420, 2023, 11, 25, isSuper);
    }

    public SuperDetails(int number, int year, int month, int day, boolean isSuper) {
        super(number, year, month, day);
        this.isSuper = isSuper;
    }
}
