package user_def_type.meeting;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Appoitment extends Event {
    Set<Person> participants=new HashSet<>();


    boolean invite(Person person){
        boolean result=false;
        return result;
    }


    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
