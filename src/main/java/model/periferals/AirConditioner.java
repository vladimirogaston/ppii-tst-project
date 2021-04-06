package model.periferals;

import model.Status;

public class AirConditioner {

    private int temperature;

    private Status state;

    public AirConditioner(){
        this.state = Status.OFF;
    }

    public void turnOn(){
        this.state = Status.ON;
    }

    public void turnOff() {
        this.state = Status.OFF;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
