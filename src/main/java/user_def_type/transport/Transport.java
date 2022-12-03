package user_def_type.transport;

import java.time.LocalDateTime;

public abstract class Transport {
    int maxSpeed;
    String producer;
    String model;

    public Transport(int maxSpeed, String producer, String model) {
        this.maxSpeed = maxSpeed;
        this.producer = producer;
        this.model = model;
    }

    abstract LocalDateTime move(GeoPoint start, GeoPoint end, LocalDateTime startTime );
    abstract  boolean  startEngine();
    abstract  boolean   stopEngine();
    abstract boolean refuel();

    final boolean  travelling(GeoPoint ... trafficRoute){
        boolean result=true;
        refuel();
        startEngine();
        LocalDateTime next=null;
         for (int i=0;i<trafficRoute.length-1;i++ ) {
         next=move(trafficRoute[i],trafficRoute[i+1],next==null?LocalDateTime.now():next);
        }
        stopEngine();
        return  result;
    }

}
