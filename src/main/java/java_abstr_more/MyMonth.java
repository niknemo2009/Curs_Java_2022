package java_abstr_more;

import java.time.DateTimeException;
import java.time.Month;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/*
Implement a regular MonthClass that behaves exactly (as far as
possible) as the Month list.
 */
// !!!!!!!!!!!!!!!!!!! Not Complete
public class MyMonth {
 static   private Map<Integer, String> data=new HashMap<>();
 private int numberOfMonth;

 static {
     data.put(1, Month.JANUARY.name());
     data.put(2, Month.FEBRUARY.name());
     data.put(3, Month.MARCH.name());
     data.put(4, Month.APRIL.name());
     data.put(5, Month.MAY.name());
     data.put(6, Month.JUNE.name());
     data.put(7, Month.JULY.name());
     data.put(8, Month.AUGUST.name());
     data.put(9, Month.SEPTEMBER.name());
     data.put(10, Month.OCTOBER.name());
     data.put(11, Month.NOVEMBER.name());
     data.put(12, Month.DECEMBER.name());
 }

    public MyMonth(RangeOfMonth numberOfMonth) {
        this.numberOfMonth = numberOfMonth.getNumber();

    }

    public MyMonth(String nameOfMonth) {
        if(data.values().contains(nameOfMonth)){
            for (Map.Entry<Integer,String> pair:data.entrySet() ) {
                if(pair.getValue().equals(nameOfMonth.toUpperCase())){
                    this.numberOfMonth= pair.getKey();
                    break;
                }
            }
            if(numberOfMonth==0){
                throw new DateTimeException("Error in name of month !");
            }
        }
    }

    enum RangeOfMonth{

     FIRST(1),SECOND(2),THIRD(3),FOURTH(4),FIFTH(5),
        SIXTH(6),SEVENTH(7),EIGHTH(8),NINTH(9),TENTH(10),ELEVENTH(11),TWELFTH(12);
        private final int number;
        RangeOfMonth(int number) {
            this.number = number;
        }
        int getNumber(){
            return  number;
        }
    }

    public static void main(String[] args) {
        System.out.println(Month.JANUARY.name());

    }
}
