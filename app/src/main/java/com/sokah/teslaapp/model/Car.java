package com.sokah.teslaapp.model;

public class Car {

    private String id,name,waranty,imgUrl;
    private int price,weight,aceleration,speed;

    public Car(){


    }
    public Car(String id,String name, String waranty, String imgUrl, int price, int weight,int aceleration,int speed) {
        this.id = id;
        this.name = name;
        this.waranty = waranty;
        this.imgUrl = imgUrl;
        this.price = price;
        this.weight = weight;
        this.aceleration = aceleration;
        this.speed = speed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaranty() {
        return waranty;
    }

    public void setWaranty(String waranty) {
        this.waranty = waranty;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAceleration() {
        return aceleration;
    }

    public void setAceleration(int aceleration) {
        this.aceleration = aceleration;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
