## 说明

Java语言在Object类中定义了clone方法，用于克隆对象。要使用clone方法，需要克隆的类就需要实现`java.lang.Cloneable`接口。
如果没有实现`Cloneable`接口，就调用clone方法，会抛出CloneNotSupportException。

## 代码实现

第一个版本

```java

public class Product {
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
}

public class Header {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Body {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

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

```

上面使用java的clone实现了原型模式，但在clone方法中克隆是浅克隆。
浅克隆：字符在克隆按值传递的数据(基本数据类型，String类型)，对于引用类型的数据不会进行克隆，因此原型的引用类型数据和克隆出来的实例的引用类型数据是指向同一个内存地址。
这意味着如果克隆出来的实例的引用类型数据发生变化，会影响到原型实例。

```java
public class Application {
    public static void main(String[] args){
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
        // 打印原型实例和克隆实例，会发现原型实例的product也跟着发生变化
        System.out.println(p);
        System.out.println(copy);
    }
}
```

要解决这个问题，就使用深克隆：除了按值传递的数据外，还要克隆引用类型的数据。

> 深克隆的特点：如果被克隆的对象里的属性数据是引用类型，则需要一直递归克隆下去。

使用深克隆完善上面的代码，则需要将Product, Header, Body都实现clone方法。Prototype和Product在clone方法中重新设置属性。

```java

public class Product implements Cloneable {
    private Header header;
    private Body body;

    // 省略getter, setter

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Product p = (Product)super.clone();
        p.setBody((Body) p.getBody().clone());
        p.setHeader((Header) p.getHeader().clone());
        return p;
    }
}

public class Header implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Body implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Prototype implements Cloneable {
    private Product product;

    public Prototype(Product product) {
        this.product = product;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype p = (Prototype)super.clone();
        p.setProduct((Product) p.getProduct().clone());
        return p;
    }

   

    // 省略 getter, setter, toString
}

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

```