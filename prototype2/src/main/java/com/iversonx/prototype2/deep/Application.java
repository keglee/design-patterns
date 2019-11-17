package com.iversonx.prototype2.deep;

public class Application {
    public static void main(String[] args) throws Exception {
        Header header = new Header();
        header.setName("Header");

        Body body = new Body();
        body.setName("Body");

        Product product = new Product();
        product.setBody(body);
        product.setHeader(header);

        Prototype p = new Prototype(product);
        // 通过原型克隆新实例
        Prototype copy = (Prototype)p.clone();
        // 改变新实例的引用类型数据
        Product newProduct = copy.getProduct();
        newProduct.setHeader(new Header());
        newProduct.setBody(new Body());
        copy.setProduct(newProduct);
        System.out.println(p);
        System.out.println(copy);
    }

}
