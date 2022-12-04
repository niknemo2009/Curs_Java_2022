package user_def_type.transport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Currency {
    USD(1.0f), EUR(1.2f), GBR(2.3f), UAH(0.025f);
    Map<LocalDate, Float> history = new HashMap<>();

    Currency(float newCourse) {
        setCourseForUSD(newCourse);
    }

    void setCourseForUSD(float currentCourse) {
        history.put(LocalDate.now(), currentCourse);
    }

    float getCourseOnDay(LocalDate date) {
      float result=-1;
        if (history.containsKey(date)) {
        history.get(date);
        }else{
            for (LocalDate temp:new ArrayList<LocalDate>(history.keySet() ).stream().sorted().collect(Collectors.toList()) ){
                if(result==-1 || temp.isBefore(date)){
                    result=history.get(temp);
                }
            }
        }
      return  result;
    }
}
