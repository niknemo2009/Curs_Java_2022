package user_def_type.transport;

import java.time.LocalDateTime;

public class Bus extends Car{
private int length;
private int wide;
private int height;

    public Bus(int maxSpeed, String producer, String model, Tyre[] tyres, int MAX_COUNT_PASSENGER, String FACTORY_NUMBER, int length, int wide, int height) {
        super(maxSpeed, producer, model, tyres, MAX_COUNT_PASSENGER, FACTORY_NUMBER);
        this.length = length;
        this.wide = wide;
        this.height = height;
    }

    @Override
    LocalDateTime move(GeoPoint start, GeoPoint end, LocalDateTime startTime) {
        checkTickets();
        return super.move(start, end, startTime);
    }

    private boolean checkTickets() {
        return  true;
    }
}
