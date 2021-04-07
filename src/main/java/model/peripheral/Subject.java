package model.peripheral;

import java.util.LinkedList;
import java.util.List;

public abstract class Subject {

    protected List<Observer> observerList;

    public Subject() {
        observerList = new LinkedList<>();
    }

    public void add(Observer observer){
        observerList.add(observer);
    }

    public void remove(Observer observer){
        observerList.remove(observer);
    }

    public abstract void notifyObservers();
}
