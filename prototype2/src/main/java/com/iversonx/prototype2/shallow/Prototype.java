package com.iversonx.prototype2.shallow;

public class Prototype implements Cloneable {
    private Product product;

    public Prototype(Product product) {
        this.product = product;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "product[header: " + product.getHeader().getName() + ", body: " + product.getBody().getName() + "]";
    }
}
