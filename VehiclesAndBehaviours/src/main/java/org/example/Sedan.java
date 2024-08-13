package org.example;

public class Sedan extends Vehicle {

    public Sedan(String vin, String model, Engine engine, String tyres) {
        super(vin, model, engine, tyres);
    }

    @Override
    public void displayInfo() {
        System.out.println("SUV Info - VIN: " + vin + "\nModel: " + model + "\nEngine Serial: " + engine.getSerialNumber() + "\nTyres: " + tyres);
    }

    @Override
    public void start() {
        if (isStarted()) {
            System.out.println("Error: The car is already started.");
        } else {
            setStarted(true);
            System.out.println("Car started.");
        }
    }

    @Override
    public void drive() {
        if (!isStarted()) {
            System.out.println("Error: Cannot drive. The car is not started.");
        } else if (isDriving()) {
            System.out.println("Error: The car is already driving.");
        } else {
            setDriving(true);
            System.out.println("Car is now moving.");
        }
    }

    @Override
    public void stop() {
        if (!isStarted()) {
            System.out.println("Error: Cannot stop. The car is not started.");
        } else if (!isDriving()) {
            System.out.println("Car is stopped.");
            setStarted(false);
        } else {
            System.out.println("Car is stopped from moving.");
            setDriving(false);
        }
    }
}
