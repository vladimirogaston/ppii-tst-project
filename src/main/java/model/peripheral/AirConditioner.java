package model.peripheral;

public class AirConditioner extends Subject {

    private int temperature;

    private Status state;

    public AirConditioner(){
        this.state = Status.OFF;
        temperature = 24;
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(this));
    }

    public void turnOn(){
        state = Status.ON;
        notifyObservers();
    }

    public void turnOff() {
        state = Status.OFF;
        notifyObservers();
    }

    public void upTemperature() {
        temperature++;
        notifyObservers();
    }

    public void downTemperature() {
        temperature--;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "AirConditioner{" +
                "temperature=" + temperature +
                ", state=" + state +
                '}';
    }
}
