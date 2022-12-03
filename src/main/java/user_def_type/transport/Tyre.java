package user_def_type.transport;

public class Tyre {
    private int currentPressure;
    private final int MAX_PRESSURE;

    public Tyre(int MAX_PRESSURE) {
        this.MAX_PRESSURE = MAX_PRESSURE;
    }

    public int getCurrentPressure() {
        return currentPressure;
    }

    public void setCurrentPressure(int currentPressure) {
        this.currentPressure = currentPressure<MAX_PRESSURE&& currentPressure>0?currentPressure:this.currentPressure;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "currentPressure=" + currentPressure +
                '}';
    }
}
