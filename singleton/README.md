## 目的

保证一个类仅有一个实例，并提供访问这个实例的全局访问点

> 单例模式用来保证这个类在运行期间只会被创建一个类实例，并提供全局访问这个实例的方法。
> 单例模式的本质：控制一个类的实例数量。
> 以下讲解的单例模式的范围是单虚拟机范围，如果有多个虚拟机，那么每个虚拟机至少有一个单例类的实例。

## 代码实现

懒汉式单例模式

1. 私有化构造方法
2. 定义一个变量来存储类的实例，并使用`private static`进行修饰，因为这个变量要在静态方法中使用
3. 提供获取实例的静态方法
4. 在静态方法里判断变量是否有值，如果没有就创建一个实例，有就直接返回

```java

public class Singleton {
    private static Singleton instance;
    
    private Singleton(){}
    
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```

懒汉式单例模式采用了延迟加载的思想，这样的好处是，如果系统一直没有调用该类的方法，就不需要去初始化实例，从而节约了资源。

懒汉式单例模式还体现了缓存的思想，即每次操作的时候，先该类的实例是否已经初始化，如果有，就直接使用；如果没有就初始化实例，
并存储起来，下次访问的时候直接使用


饿汉式单例模式

1. 私有化构造函数
2. 定义静态变量，并直接创建实例
3. 定义一个全局访问实例的方法

```java

public class Singleton {
    private static Singleton instance = new Singleton();
    
    private Singleton(){}
    
    public static Singleton getInstance() {
        return instance;
    }
}

```

## 懒汉式和饿汉式的特点

从时间和空间的角度来说：懒汉式是时间换空间，每次获取实例时先判断是否需要创建实例；饿汉式是空间换时间，当类加载的时候就会创建类实例。

从线程安全的角度来说：不加同步的懒汉式的线程不安全的，多个线程同时调用getInstance方法可能导致出现多个实例。饿汉式是线程安全的，因为
虚拟机保证只会装载一次，并且装载类的时候是不会发生并发的。

## 线程安全的懒汉式单例模式

1. 通过对getInstance()方法进行加锁

```java

public class Singleton {
    private static Singleton instance;
    
    private Singleton(){}
    
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```

3. 双重检查加锁

并不是每次进入getInstance方法都要同步，而是先进入方法，在检查实例不存在时，进入同步块；在进入同步块后，再次检查实例是否存在，如果不存在就创建。

在使用双重检查方式时，还需要对变量使用`volatile`进行修饰。使用`volatile`的目的是保证将`instance =newInstance();`这条语句的原子性，

将instance =newInstance();步骤拆分后
1. 分配内存
2. 初始化
3. 将instance指向分配的内存空间

因为instance是volatile类型变量，因此在volatile写操作之前的任何操作都是不可重排序的，即23的顺序不可重排序。

如果不使用volatile修饰，可能出现在另一个线程中想要使用instance，发现instance!=null，实际上instance还未初始化完毕,这种情况是因为上述2,3步骤被重排序了，先执行了3

```java

public class Singleton {
    private static Singleton instance;
    
    private Singleton(){}
    
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

```


## 更好的单例实现方式

1. 静态内部类实现单例模式

### 静态内部类相关知识
- 被`static`修饰的成员内部类。没有被`static`修饰的成员内部类被称为对象级内部类

- 静态内部类相当于其外部类的`static`属性，静态内部类的对象与外部类对象间不存在依赖关系，因此可以直接创建。

- 静态内部类中可以定义静态方法，在静态方法中只能引用外部类中的静态成员。

- 静态内部类只有在第一次被使用时才会被加载。

### JVM隐式同步

以下情况JVM会进行隐式同步，不需要使用自己使用加锁来进行同步：

- 由静态初始化器（在静态字段上或static块中的初始化器）初始化数据时
- 访问final字段时
- 在创建线程之前创建对象时
- 线程可以看见它将要处理的对象时

```java

public class Singleton {
    private Singleton() {}
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}

```

好处：在不加锁和提前初始化的情况下，实现了延迟加载和线程安全。


2. 使用枚举实现单例模式

### 枚举类型

- 枚举类型实质上是也是一个类，可以有自己的属性和方法。
- 枚举类型的基本思想是通过公有的静态final域为每个枚举常量导出实例的类。

使用枚举实现单例，只要编写一个包含单个元素的枚举类型即可。

```java

public enum Singleton {
    INSTANCE;
    
    public void operation() {
        // 功能处理
    }
}

```

使用枚举来实现单例，代码更简洁，而且无偿地提供了序列化，并由JVM从根本上提供保障，防止多次实例化，是简洁，高效，安全的实现单例的方式。

## 防止非法攻击单例模式

上述单例实现方式，除了枚举方式外，其他几种模式都可以使用反射和序列化的方式破坏单例。


使用反射机制破坏单例
```java

public class ReflectAttack {
    public static void main(String[] args) throws Exception {

        // 正常的获取实例方式
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);

        
        Class objClass = Singleton.class;
        // 获取类的构造器
        Constructor constructor = objClass.getDeclaredConstructor();
        // 把构造器私有权限放开
        constructor.setAccessible(true);
        // 反射创建实例
        Singleton newSingleton = (Singleton) constructor.newInstance();
        System.out.println(newSingleton);



    }
}

```

对于反射机制破坏单例，可以在单例类中增加一个标记，然后在私有构造函数中根据这个标记来抛出异常的方式来防止

```java

public class Singleton {
    private static Singleton instance;
    private static boolean flag = false;
    private Singleton() {
        if(flag) {
            throw new InstantiationError("error");
        } else {
            flag = true;
        }
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// 或

public class Singleton {
    private Singleton() {
        if(SingletonHolder.instance != null) {
            throw new InstantiationError("error");
        }
    }
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}

```

使用序列化方式破坏单例

```java

public class SerializeAttack {
    public static void main(String[] args) throws Exception{
        Singleton instance = Singleton.getInstance();
        // Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(instance);
        // Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        Singleton newInstance = (Singleton) ois.readObject();

        // 判断是否是同一个对象
        System.out.println(instance);
        System.out.println(newInstance);
    }
}

```

对于使用序列化方式破坏单例，可以在单例类中增加 `public Object readResolve(){return instance}`来防止 

```java

public class Singleton implements Serializable {
    private Singleton() {
        if(SingletonHolder.instance != null) {
            throw new InstantiationError("error");
        }
    }
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private Object readResolve() {
        return SingletonHolder.instance;
    }
}

```