package java_17.list_concepts;

import java.util.Random;

// enum is a little like an array, except it's elements are known, not changeable,
//      and each element can be reffered to by a constant name, instead of an index position

// in its simplest form, is described like a class, but the keyword, enum, replaces the
//      keyword "class"

// You can name the enum with any valid identifier, but like a class, Upper CalemCase is the preferred style.

// within the enum body, you declare a list of constant identifiers, separated by commas. 
// by convention, these are all uppercase labels


public class Enum {
    
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.TUESDAY;
        System.out.println(weekDay);
        for (int i = 0; i < 10; i++ ) {
            weekDay = getRandomDay();
            // System.out.printf("Name is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());

            // if (weekDay == DayOfTheWeek.FRIDAY) {
            //     System.out.println("Found a Friday!!!");
            // }
            switchDayOfWeek(weekDay);
        }

        for (Topping topping : Topping.values()) {
            System.out.println(topping + ": " + topping.getPrice());
        }
    }

    public static DayOfTheWeek getRandomDay() {
        int randomInteger = new Random().nextInt(7);    // 7 isn't included in the random ints
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        switch(weekDay) {
            case SUNDAY -> System.out.println("Sunday is Day " + weekDayInteger);
            case MONDAY -> System.out.println("Monday is Day " + weekDayInteger);
            case TUESDAY -> System.out.println("Tuesday is Day " + weekDayInteger);
            case WEDNESDAY -> System.out.println("Wednesday is Day " + weekDayInteger);
            case THURSDAY -> System.out.println("Thursday is Day " + weekDayInteger);
            case FRIDAY -> System.out.println("Friday is Day " + weekDayInteger);
            case SATURDAY -> System.out.println("Saturday is day " + weekDayInteger);
            default -> System.out.println("Unknown day of the week");
        }
    }
}


// these can be in their own file, 
//      but they would need "public" added to their declaration
enum DayOfTheWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum MonthsOfTheYear {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

enum Topping {
    MUSTARD, PICKLES, BACON, CHEDDAR, TOMATO;

    public double getPrice() {
        return switch(this) {
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.75;
        };
    }
}
