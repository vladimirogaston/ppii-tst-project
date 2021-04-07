package model.peripheral;

public class Radio extends Subject{

    private int volume;

    private Status status;

    private Band band;

    public Radio() {
        volume = 12;
        turnOff();
        setAM();
    }

    public void turnOn(){
        status = Status.ON;
        notifyObservers();
    }

    public void turnOff(){
        status = Status.OFF;
        notifyObservers();
    }

    public void upVolume() {
        volume++;
        notifyObservers();
    }

    public void downVolume() {
        volume--;
        notifyObservers();
    }

    public void setAM(){
        band = Band.AM;
        notifyObservers();
    }

    public void setFM(){
        band = Band.FM;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public String toString() {
        return "Radio{" +
                "volume=" + volume +
                ", status=" + status +
                ", band=" + band +
                '}';
    }
}