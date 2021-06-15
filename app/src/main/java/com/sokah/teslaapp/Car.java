package com.sokah.teslaapp;

public class Car {

    private String id,name,waranty,imgUrl;
    private float price,weight;

    public Car(){


    }
    public Car(String id,String name, String waranty, String imgUrl, float price, float weight) {
        this.id = id;
        this.name = name;
        this.waranty = waranty;
        this.imgUrl = imgUrl;
        this.price = price;
        this.weight = weight;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
