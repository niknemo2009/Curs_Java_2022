package user_def_type;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

/*
1. Create a Date[] and set its fields by values queried from the user.
2. Write the UDT Date with following additions:
a) Add a dctor initializing a new Date instance with the current date.
b) Add a ctor, that allows the caller to specify, that each access and each
modification of the encapsulated field should be logged to the console.
c) Mind to create JavaDoc comments on the methods!
d) Mind to create unit tests!
 */
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  COMPLETE
public class MyDate {
    /**
     * @author Nezdolii Yurii
     */
    public static final String PROBLEM_WITH_METHOD_PARAMETER = "Problem with method parameter !!!";
    private LocalDate date;

    /**
     * This is default constructor.
     */
    MyDate() {
        date = LocalDate.now();
    }

    /**
     * This is second constructor.
     *
     * @param day   valid value 1-31
     * @param month
     * @param year  <p>
     *              If parameters of constructors is not valid the  was created date will be equal toDay.
     *              </p>
     */
    MyDate(int day, Month month, int year) {
        try {
            date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            System.out.println("Problem with constructor parameters !!!");
            date = LocalDate.now();
        } catch (NullPointerException e) {
            System.out.println("Problem with constructor parameters !!!");
            date = LocalDate.now();
        }
    }

    /**
     * @return number day of month
     */
    int getDayofMonth() {
        System.out.println("Read day !");
        return date.getDayOfMonth();
    }

    /**
     * @return instance enum java.util.time.Month
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html">java.util.time.Month</a>
     */
    Month getMonth() {
        return date.getMonth();
    }

    /**
     * @return value number of Year
     */
    int getYear() {
        return date.getYear();
    }

    /**
     * @param month
     */
    void setMonth(Month month) {
        if (month != null) {
            try {
                date = LocalDate.of(getYear(), month, getDayofMonth());
                System.out.println("Month changed !");
            } catch (DateTimeException e) {
                System.out.println("Problem with dayOfMonth in " + month);
            }

        } else {
            System.out.println(PROBLEM_WITH_METHOD_PARAMETER);
        }

    }

    /**
     * @param year
     */
    void setYear(int year) {
        try {
            date = LocalDate.of(year, getMonth(), getDayofMonth());
            System.out.println("Year changed !");
        } catch (DateTimeException e) {
            System.out.println(PROBLEM_WITH_METHOD_PARAMETER);

        }
    }

    /**
     * @param day
     */
    void setDay(int day) {
        try {
            date = LocalDate.of(getYear(), getMonth(), day);
            System.out.println("Day changed !");
        } catch (DateTimeException e) {
            System.out.println(PROBLEM_WITH_METHOD_PARAMETER);

        }
    }


}


