package user_def_type.meeting;

import java.util.*;

public class Person {
    String name;
    Set<Event> schedule=new TreeSet<>();
    Map<TypeContact, Set<String>> contacts=new EnumMap(TypeContact.class);

boolean addContact(TypeContact type, String value){
    boolean result=false;
    return result;
}
boolean deleteContact(TypeContact type,String contact){
    boolean result=false;
    return result;
}
boolean changeSchedule(Event event){
    boolean result=false;
    return result;
}
boolean deleteEvent(Event event){
    boolean result=false;
    return result;
}
}

