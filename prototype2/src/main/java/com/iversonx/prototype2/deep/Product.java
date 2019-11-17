package com.iversonx.prototype2.deep;

public class Product implements Cloneable {
    private Header header;
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Product p = (Product)super.clone();
        p.setBody((Body) p.getBody().clone());
        p.setHeader((Header) p.getHeader().clone());
        return p;
    }
}
