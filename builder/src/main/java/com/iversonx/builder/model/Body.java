package com.iversonx.builder.model;

public class Body {
    private String name;
    private String price;
    private String amount;

    public Body(String name, String price, String amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }


    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }

}
