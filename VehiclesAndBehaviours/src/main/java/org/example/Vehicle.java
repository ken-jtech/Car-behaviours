package org.example;

public abstract class Vehicle implements StartCar, DriveCar, StopCar {
    protected String vin;
    protected String model;
    protected Engine engine;
    protected String tyres;

    private boolean isStarted = false;
    private boolean isDriving = false;

    public Vehicle(String vin, String model, Engine engine, String tyres) {
        this.vin = vin;
        this.model = model;
        this.engine = engine;
        this.tyres = tyres;
    }

    @Override
    public void start() {
        System.out.println("Engine started...");
    }

    @Override
    public void stop() {
        System.out.println("Engine stopped...");
    }

    protected boolean isStarted() {
        return isStarted;
    }

    protected void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    protected boolean isDriving() {
        return isDriving;
    }

    protected void setDriving(boolean isDriving) {
        this.isDriving = isDriving;
    }

    public abstract void displayInfo();
}
