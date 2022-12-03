package user_def_type.transport;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Car extends  Transport{
   private Tyre[] tyres;
   private final int MAX_COUNT_PASSENGER;
   private final String FACTORY_NUMBER;

    public Car(int maxSpeed, String producer, String model, Tyre[] tyres, int MAX_COUNT_PASSENGER, String FACTORY_NUMBER) {
        super(maxSpeed, producer, model);
        this.tyres = tyres;
        this.MAX_COUNT_PASSENGER = MAX_COUNT_PASSENGER;
        this.FACTORY_NUMBER = FACTORY_NUMBER;
    }

    boolean changeTyre(Tyre newTyre, int order){
    boolean result=false;
        if(order>=0&&order<tyres.length){
        tyres[order]=newTyre;
         result=true;
        }
    return result;
    }

    boolean setPressure(int value){
        boolean result=true;
        for (Tyre temp:tyres  ) {
            if(!temp.setCurrentPressure(value)){
                result=false;
                break;
            }
        }
        return result;
    }
    double getAveragePressure(){
     return Arrays.stream(tyres).mapToInt(x->x.getCurrentPressure()).average().getAsDouble();
    }
    @Override
    LocalDateTime move(GeoPoint start, GeoPoint end, LocalDateTime startTime) {
        return null;
    }

    @Override
    boolean startEngine() {
        return false;
    }

    @Override
    boolean stopEngine() {
        return false;
    }

    @Override
    boolean refuel() {
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "count tyres=" + tyres.length +
                " , MAX_COUNT_PASSENGER=" + MAX_COUNT_PASSENGER +
                ", FACTORY_NUMBER='" + FACTORY_NUMBER + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
