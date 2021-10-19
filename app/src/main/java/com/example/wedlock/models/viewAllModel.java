package com.example.wedlock.models;

public class viewAllModel {

    String name;
    String description;
    String img_url;
    String price;
    String number;
    String type;

    public viewAllModel() {
    }

    public viewAllModel(String name, String description, String img_url, String price, String number, String type) {
        this.name = name;
        this.description = description;
        this.img_url = img_url;
        this.price = price;
        this.number = number;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
