package java_17.oop_encapsulation;

import java.lang.Math;

// public class Printer {
//     private int tonerLevel;
//     private int pagesPrinted;
//     // if true the printer can print 2 sided pages
//     private boolean duplex;

//     public Printer(boolean duplex) {
//         this(100, 0, duplex);
//     }

//     public Printer(int tonerLevel, int pagesPrinted, boolean duplex) {
//         this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
//         if (pagesPrinted < 0) {
//             this.pagesPrinted = 0;
//         } else {
//             this.pagesPrinted = pagesPrinted;
//         }
//         this.duplex = duplex;
//     }

//     private int getTonerLevel() {
//         return tonerLevel;
//     }

//     private int getPagesPrinted() {
//         return pagesPrinted;
//     }

//     private boolean getDuplex() {
//         return this.duplex;
//     }

//     private void setPagesPrinted(int pagesPrinted) {
//         this.pagesPrinted = pagesPrinted;
//     }

//     private void setTonerLevel(int tonerLevel) {
//         this.tonerLevel = tonerLevel;
//     }

//     public int addToner(int tonerAmount) {
//         int tonerTotal = tonerAmount + this.getTonerLevel();
//         if (tonerTotal > 100) {
//             System.out.println("Toner is full!");
//             this.setTonerLevel(100);
//         } else if (tonerTotal < 0) {
//             return -1;
//         } else {
//             this.setTonerLevel(tonerTotal);
//         }
//         return this.getTonerLevel();
//     }

//     public void printPages(int pages) {
//         int pagesNeeded = 0;
//         if (this.getDuplex()) {
//             int pagesD = (pages / 2) + (pages % 2);
//             System.out.println("This printer will print double sided pages.");
//             pagesNeeded = pagesD;
//         } else {
//             pagesNeeded = pages;
//         }
//         this.setPagesPrinted(this.getPagesPrinted() + pagesNeeded);
//         System.out.println("Printing: " + pagesNeeded + " pages");
//         System.out.println("Total pages printed: " + this.getPagesPrinted());
//     }

//     public static void main(String[] args) {
//         Printer duplexPrinter = new Printer(true);

//         System.out.println("New Toner Level: " + duplexPrinter.addToner(25));
//         duplexPrinter.printPages(25);

//         Printer regularPrinter = new Printer(false);
//         System.out.println("New Toner Level: " + regularPrinter.addToner(-25));
//         regularPrinter.printPages(25);
//         regularPrinter.printPages(25);
//         regularPrinter.printPages(25);

//     }
// }
