package pl.coderslab.model;

import java.sql.Date;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private Date yearOfProd;
    private String registry;
    private Date nextInspection;
    private int ownerId;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, Date yearOfProd, String registry, Date nextInspection, int ownerId) {
        this.model = model;
        this.brand = brand;
        this.yearOfProd = yearOfProd;
        this.registry = registry;
        this.nextInspection = nextInspection;
        this.ownerId = ownerId;
    }

    public Vehicle(int id, String model, String brand, Date yearOfProd, String registry, Date nextInspection, int ownerId) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.yearOfProd = yearOfProd;
        this.registry = registry;
        this.nextInspection = nextInspection;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getYearOfProd() {
        return yearOfProd;
    }

    public void setYearOfProd(Date yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public Date getNextInspection() {
        return nextInspection;
    }

    public void setNextInspection(Date nextInspection) {
        this.nextInspection = nextInspection;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
