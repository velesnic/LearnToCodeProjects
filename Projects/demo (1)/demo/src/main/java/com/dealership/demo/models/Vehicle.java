package com.dealership.demo.models;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String color;
    private String vehicleType;
    private int odometer;
    private double price;
    private boolean sold;

    public Vehicle(int vin, int year, String make, String model, String color, String vehicleType, int odometer, double price, boolean sold) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.vehicleType = vehicleType;
        this.odometer = odometer;
        this.price = price;
        this.sold = sold;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString(){
        return String.format("%d|%d|%s|%s|%s|%s|%d|%f", this.getVin(), this.getYear(), this.getMake(), this.getModel(),
                this.getColor(), this.getVehicleType(), this.getOdometer(), this.getPrice());
    }
}
