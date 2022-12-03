package user_def_type.transport;

import java.time.LocalDateTime;

public class Car extends  Transport{
   private Tyre[] tyres;

    public Car(int maxSpeed, String producer, String model, Tyre[] tyres) {
        super(maxSpeed, producer, model);
        this.tyres = tyres;
    }
    boolean changeTyre(Tyre newTyre, int order){


    }

    int getAveragePresure(){

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
}
