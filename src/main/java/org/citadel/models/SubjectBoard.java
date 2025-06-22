package org.citadel.models;

public class SubjectBoard {

    private Observer observer;

    public void subscribe(Observer observer) {
        this.observer = observer;
    }

    public void initialize() {
        observer.initialize();
    }

    public void begin() {
        observer.begin();
    }

    public void end() {
        observer.end();
    }

    public void exit() {
        observer.exit();
    }
}
