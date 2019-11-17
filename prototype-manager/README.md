## 目的

如果系统中的原型可以被动态地创建和销毁，那就需要在系统中维护一个当前可用的原型注册表，这个注册表就被称为原型管理器。
一般情况下，除了向原型管理器里面添加原型对象时通过`new`来创建的对象，其余时候都是向原型管理器来请求原型实例，然后通
过克隆方法来获取新的实例，这就可以实现动态管理，或动态切换具体的实现对象实例。

## 代码实现

定义原型接口
```java
public interface Prototype {
    Prototype clone();
    String getName();
    void setName(String name);
}
```

实现原型接口
```java
public class ConcretePrototype1 implements Prototype, Cloneable {
    private String name;
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Now in Prototype1, name=" + name;
    }
}

public class ConcretePrototype2 implements Prototype, Cloneable {
    private String name;
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Now in Prototype2, name=" + name;
    }
}

```

实现原型管理器

```java

public class PrototypeManager {
    /**
     * 用来记录原型编号和原型实例的对应关系
     */
    private static Map<String, Prototype> map = new HashMap<>();

    /**
     * 私有构造方法，避免外部无谓的创建实例
     */
    private PrototypeManager() {

    }

    /**
     * 添加或修改原型
     * @param id 原型编号
     * @param prototype 原型实例
     */
    public synchronized static void setPrototype(String id, Prototype prototype) {
        map.put(id, prototype);
    }

    /**
     * 删除原型
     * @param id 原型编号
     */
    public synchronized static void removePrototype(String id) {
        map.remove(id);
    }

    public synchronized static Prototype getPrototype(String id) {
        return map.get(id);
    }
}

```

## 调用演示

```java

public class Application {
    public static void main(String[] args) throws Exception{
        Prototype p = new ConcretePrototype1();
        p.setName("Prototype1");
        PrototypeManager.setPrototype(p.getName(), p);

        // 获取原型来场景对象
        Prototype p2 = PrototypeManager.getPrototype(p.getName()).clone();
        System.out.println("第一个实例:" + p2);

        // 切换原型
        PrototypeManager.setPrototype(p.getName(), new ConcretePrototype2());

        // 再次获取
        Prototype p3 = PrototypeManager.getPrototype(p.getName()).clone();
        System.out.println("第二个实例:" + p3);

        // 注销
        PrototypeManager.removePrototype(p.getName());

        // 再次尝试获取
        Prototype p4 = PrototypeManager.getPrototype(p.getName()).clone();
        System.out.println("第三个实例:" + p4);

    }
}

```