package com.project.cinemago.observer;

public abstract class Observable {

    public abstract void registerObserver(Observer o);

    public abstract void removeObserver(Observer o);

    public abstract void notifyObservers(String message);

}
