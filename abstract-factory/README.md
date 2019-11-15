## 目的
提供用于创建一系列相关或依赖的对象，而不指定这些对象的具体类。

## 解释
现实世界的例子

> 要创建一个王国，我们需要具有共同主题的物品。 精灵王国需要一个精灵王，精灵城堡和精灵军队，而兽人王国则需要一个兽王，精灵城堡和兽人军队。 王国中的对象之间存在依赖性。

简而言之

> 抽象工厂是工厂的工厂。将单独但相关或依赖的工厂组合在一起，而不指定这些工厂的具体类的工厂。

维基百科说

> 抽象工厂模式提供了一种封装一组具有相同主题的单个工厂而无需指定其具体类的方法

**代码实现**

```java
public interface Castle {
  String getDescription();
}
public interface King {
  String getDescription();
}
public interface Army {
  String getDescription();
}

// 精灵实现 ->
public class ElfCastle implements Castle {
  static final String DESCRIPTION = "This is the Elven castle!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
public class ElfKing implements King {
  static final String DESCRIPTION = "This is the Elven king!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
public class ElfArmy implements Army {
  static final String DESCRIPTION = "This is the Elven Army!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}

// 兽人实现类似.....

```

抽象工厂和实现

```java
public interface KingdomFactory {
  Castle createCastle();
  King createKing();
  Army createArmy();
}

public class ElfKingdomFactory implements KingdomFactory {
  public Castle createCastle() {
    return new ElfCastle();
  }
  public King createKing() {
    return new ElfKing();
  }
  public Army createArmy() {
    return new ElfArmy();
  }
}

public class OrcKingdomFactory implements KingdomFactory {
  public Castle createCastle() {
    return new OrcCastle();
  }
  public King createKing() {
    return new OrcKing();
  }
  public Army createArmy() {
    return new OrcArmy();
  }
}
```

增加FactoryMaker，负责返回ElfKingdomFactory和OrcKingdomFactory

```java
public class FactoryMaker {
    public enum KingdomType {
        ELF, ORC
    }

    public static KingdomFactory makeFactory(KingdomType type) {
        switch (type) {
            case ELF:
                return new ElfKingdomFactory();
            case ORC:
                return new OrcKingdomFactory();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}

public static void main(String[] args) { 
    
    System.out.println("Elf Kingdom");
    KingdomFactory kingdomFactory = FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF);
    System.out.println(kingdomFactory.createArmy().getDescription());
    System.out.println(kingdomFactory.createCastle().getDescription());
    System.out.println(kingdomFactory.createKing().getDescription());
  
    System.out.println("Orc Kingdom");
    kingdomFactory = FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC);
    System.out.println(kingdomFactory.createArmy().getDescription());
    System.out.println(kingdomFactory.createCastle().getDescription());
    System.out.println(kingdomFactory.createKing().getDescription());
 
}
```


## 适用性
以下情况可以考虑使用抽象工厂模式

* 希望一个系统独立于它的产品的创建、组合和表示时。即希望系统只是知道产品的接口，而不关心具体实现的时候。
* 如果一个系统要由多个产品系统中的一个来配置时。
* 相关产品对象系列被设计为一起使用时，使用抽象工厂模式进行约束