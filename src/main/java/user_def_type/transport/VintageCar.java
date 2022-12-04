package user_def_type.transport;

import java.time.LocalDate;

public class VintageCar extends Car {
 int price;
 Currency currency;

    public VintageCar(int maxSpeed, String producer, String model, Tyre[] tyres, int MAX_COUNT_PASSENGER, String FACTORY_NUMBER, int price, Currency currency) {
        super(maxSpeed, producer, model, tyres, MAX_COUNT_PASSENGER, FACTORY_NUMBER);
        this.price = price;
        this.currency = currency;
    }

    float getPrice(Currency currency, LocalDate date){
    return currency.getCourseOnDay(date);
    }

}
