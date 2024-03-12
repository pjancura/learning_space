package java_17.oop_encapsulation;

public class ExerciseThirtyNine {

    public static void main(String[] args) {
        Printer printer = new Printer(50, true);

        System.out.println(printer.addToner(100));

    }
}

class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    // if true the printer can print 2 sided pages
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount <= 0 || tonerAmount > 100) {
            return -1;
        } else {
            int tonerTotal = tonerAmount + this.tonerLevel;
            if (tonerTotal > 100 || tonerTotal < 0) {
                return -1;
            } else {
                this.tonerLevel = tonerTotal;
            }
            return this.tonerLevel;
        }
    }

    public int printPages(int pages) {
        int pagesToPrint = (this.duplex) ? (pages / 2) + (pages % 2) : pages;
        this.pagesPrinted = this.getPagesPrinted() + pagesToPrint;
        return pagesToPrint;
    }
}