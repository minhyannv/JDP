# Java 设计模式
## 设计模式分类：设计模式分为三种类型，共23种

### 创建型模式
**单例模式**、**工厂模式**、**抽象工厂模式**、**原型模式**、建造者模式

### 结构型模式
**适配器模式**、**装饰器模式**、**外观模式**、**代理模式**、桥接模式、装组合模式、享元模式

### 行为型模式
**策略模式**、**观察者模式**、**责任链模式**、**状态模式**、**命令模式**、**模版方法模式**、访问者模式、迭代器模式、中介者模式、备忘录模式、解释器模式

## 需要掌握的设计模式
### 创建型模式
1. 单例模式

- 定义：采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法(静态方法)。

- 单例模式之饿汉模式（静态常量）

- 实现方式：1) 构造器私有化 (防止 new )。2) 类的内部创建对象。3) 向外暴露一个静态的公共方法。

- 优点：写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。

- 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。

- 代码：

```java
class Singleton01 {
    //1.构造器私有化
    private Singleton01() {
    }
    //2.本类内部创建对象实例
    private final static Singleton01 instance = new Singleton01();
    //3.提供一个公有的静态方法，返回对象实例
    public static Singleton01 getInstance() {
        return instance;
    }
}
```

- 单例模式之饿汉模式（静态代码块）

- 实现方式：和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。

- 优缺点：同饿汉模式（静态常量）相同。

- 代码：

```java
class Singleton02 {
    //1.构造器私有化
    private Singleton02() {
    }
    //2.本类内部创建对象实例
    private static Singleton02 instance;
    //在静态代码块中创建单例对象
    static {
        instance = new Singleton02();
    }
    //3.提供一个公有的静态方法，返回对象实例
    public static Singleton02 getInstance() {
        return instance;
    }
}
```

- 单例模式之懒汉模式（线程不安全）

- 实现方式：1) 构造器私有化 (防止 new )。2) 类的内部定义对象。3) 向外暴露一个静态的公共方法（第一次调用时才创建对象）。
- 优点：起到了Lazy Loading的效果，但是只能在单线程下使用。
- 缺点：如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式。
- 代码：

```java
class Singleton03 {
    //1.类的内部定义对象
    private static Singleton03 instance;
    //2.构造器私有化
    private Singleton03() {
    }
    //3.提供静态私有方法，当使用该方法时，才去创建instance
    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
```
- 单例模式之懒汉模式（线程安全）

- 实现方式：在 getInstance（）方法上加 synchronized 关键字

- 优点：起到了Lazy Loading的效果，解决了线程不安全问题

- 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低

- 代码：

```java
class Singleton04 {
    private static Singleton04 instance;
    //1.构造器私有化
    private Singleton04() {
    }
    //2.提供静态私有方法，当使用该方法时，才去创建instance,加入同步处理的代码,线程安全
    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }
}
```

- 单例模式之双重检查

- 实现方式：在提供单例对象的方法内部进行了两次if (singleton == null)检查，保证线程安全。
- 优点：实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象，也避免的反复进行方法同步。线程安全；延迟加载；效率较高
- 代码：

```java
class Singleton05 {
    private static Singleton05 instance;
    //1.构造器私有化
    private Singleton05() {
    }
    //2.提供静态公有方法，加入双重检查代码，解决线程安全问题，同时起到了懒加载
    public static Singleton05 getInstance() {
        if (instance == null) {
            synchronized (Singleton05.class) {
                if (instance == null) {
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}
```
- 单例模式之静态内部类
- 实现方式：类内部创建静态类，并维护外部类的实例对象。静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
- 优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
- 代码：
```java
class Singleton06 {
    //1.构造器私有化
    private Singleton06() {
    }
    //2.静态内部类
    public static class Singleton06Instance {
        private static final Singleton06 instance = new Singleton06();
    }
    // 3.提供公共静态方法,直接返回实例
    public static Singleton06 getInstance() {
        return Singleton06Instance.instance;
    }
}
```
- 单例模式之枚举
- 实现方式：借助JDK1.5中添加的枚举来实现单例模式。
- 优点：不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
- 代码：

```java
enum Singleton07 {
    //属性
    INSTANCE;
    //方法
    public void method() {
        System.out.println("run method...");
    }
}
```
2. 工厂模式（简单工厂模式）
- 定义：简单工厂模式是属于创建型模式，是工厂模式的一种。简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族中最简单实用的模式。
- 实例：有披萨，汉堡包，鸡腿三种食物，将创建的具体食物对象封装到一个工厂类中，由这个类来封装实例化对象。
- 类图
![simple_factory](E:\IdeaProjects\java-learning\img\simple_factory.png)

- 代码
```java
/**
* 抽象产品(食物)
*/
interface Food {
    /**
* 吃食物的方法
*/
    void eat();
}
```
```java
/**
* 具体产品:汉堡包
*/
class Hambuger implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Hambuger...");
    }
}
```
```java
/**
* 具体产品:炸薯条
*/
class FrenchFries implements Food {
    @Override
    public void eat() {
        System.out.println("Eating FrenchFries...");
    }
}
```
```java
/**
* 具体产品:鸡腿
*/
class Drumstick implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Drumstick...");
    }
}
```

```java
/**
* 食物工厂
*/
class FoodFactory {
    /**
* 根据需求制造食品
*
* @param n
* @return
*/
    public static Food getFood(int n) {
        Food food = null;
        switch (n) {
            case 1:
                food = new Hambuger();
                break;
            case 2:
                food = new FrenchFries();
                break;
            case 3:
                food = new Drumstick();
                break;
        }
```

```java
/**
* 测试简单工厂
*/
public class TestSimpleFactory {
    public static void main(String[] args) {
        Food f = FoodFactory.getFood(2);
        f.eat();
        f = FoodFactory.getFood(1);
        f.eat();
    }
}
```
3.  工厂模式（工厂方法模式） 
- 定义：定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类。
- 和简单工厂模式对比：和简单工厂模式中工厂负责生产所有产品相比，工厂方法模式将生成具体产品的任务分发给具体的产品工厂。
- 类图：

![factory_method](E:\IdeaProjects\java-learning\img\factory_method.png)

- 代码：

```java
/**
* 抽象产品(食物)
*/
public interface Food {
    /**
* 吃食物的方法
*/
    void eat();
}
```
```java
/**
* 具体产品:炸薯条
*/
class FrenchFries implements Food {
    @Override
    public void eat() {
        System.out.println("Eating FrenchFries...");
    }
}
```

```java
/**
* 具体产品:汉堡包
*/
public class Hambuger implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Hambuger...");
    }
}
```
```java
/**
* 具体产品:鸡腿
*/
class Drumstick implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Drumstick...");
    }
}
```
```java
/**
* 抽象食物工厂
*/
public interface FoodFactory {
    Food getFood();
}
```
```java
/**
* 生产薯条的工厂
*/
public class FrenchFriesFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new FrenchFries();
    }
}
```
```java
/**
* 生产汉堡包的工厂
*/
public class HambugerFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Hambuger();
    }
}
```
```java
/**
* 生产鸡腿的工厂
*/
public class DrumstickFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Drumstick();
    }
}
```
```java
/**
* 测试工厂方法模式
*/
public class TestFactoryMethod {
    public static void main(String[] args) {
        FoodFactory foodFactory = new HambugerFactory();
        foodFactory.getFood().eat();
        foodFactory = new DrumstickFactory();
        foodFactory.getFood().eat();
    }
}
```
4. 抽象工厂模式
- 定义：抽象工厂模式通过在AbstarctFactory中增加创建产品的接口，并在具体子工厂中实现新加产品的创建。
- 类图：
![abstract_factory](E:\IdeaProjects\java-learning\img\abstract_factory.png)

- 代码：
```java
/**
* 食物接口
*/
public interface Food {
    void eat();
}
```
```java
/**
* 具体食物类：炸薯条
*/
public class FrenchFries implements Food {
    @Override
    public void eat() {
        System.out.println("Eating FrenchFries...");
    }
}
```
```java
/**
* 具体食物类：汉堡包
*/
public class Hambuger implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Hambuger...");
    }
}
```
```java
/**
* 饮料接口
*/
public interface Drink {
    void drink();
}

```
```java
/**
* 具体饮料类：咖啡
*/
public class Coffee implements Drink {
    @Override
    public void drink() {
        System.out.println("Drinking Coffee...");
    }
}
```
```java
/**
* 具体饮料类：可乐
*/
public class Coke implements Drink {
    @Override
    public void drink() {
        System.out.println("Drinking Coke...");
    }
}
```
```java
/**
* 抽象工厂
*/
public interface Factory {

    Food getFood();

    Drink getDrink();
}

```
```java
/**
* 具体工厂:金拱门
*/
public class GoldenArchFactory implements Factory {
    @Override
    public Food getFood() {
        System.out.println("金拱门店制作...");
        return new Hambuger();
    }
    @Override
    public Drink getDrink() {
        System.out.println("金拱门店制作...");
        return new Coffee();
    }
}
```

```java
/**
* 具体工厂：KFC
*/
public class KFCFactory implements Factory {

    @Override
    public Food getFood() {
        System.out.println("KFC店制作...");
        return new Hambuger();
    }

    @Override
    public Drink getDrink() {
        System.out.println("KFC店制作...");
        return new Coffee();
    }
}
```
```java
/**
* 测试抽象工厂
*/
class TestAbstractFactory {
    public static void main(String[] args) {
        Factory factory = new KFCFactory();
        factory.getFood().eat();
        factory.getDrink().drink();
        factory = new GoldenArchFactory();
        factory.getFood().eat();
        factory.getDrink().drink();
    }
}
```
### 结构型模式

1. 适配器模式
- 定义：适配器模式把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。

- 博客：https://www.cnblogs.com/java-my-life/archive/2012/04/13/2442795.html

- 适配器模式之类适配器模式

- 实现方式：让Adapter继承Adaptee类，然后再实现Target接口，来实现适配器功能。

- 优点：由于Adapter继承了Adaptee类，所以它可以根据需求重写Adaptee类的方法，使得Adapter的灵活性增强了。

- 缺点：因为java单继承的缘故，Target类必须是接口，以便于Adapter去继承Adaptee并实现Target，完成适配的功能，但这样就导致了Adapter里暴露了Adaptee类的方法，使用起来的成本就增加了。

- 实例：手机充电需要将220V的交流电转化为手机锂电池需要的5V直流电。使用电源适配器，将 AC220v ——> DC5V。

- 类图：

![class_adapter](E:\IdeaProjects\java-learning\img\class_adapter.png)

- 代码：

```java
/**
 * 源角色(Adaptee)：现在需要适配的接口。
 */
public class AC220 {
    /**
     * 输出220V交流电
     *
     * @return
     */
    public int output220V() {
        int output = 220;
        return output;
    }
}
```

```java
/**
 * 目标角色(Target)：这就是所期待得到的接口。
 * 注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 */
public interface DC5 {
    /**
     * 输出5V直流电（期待得到的接口）
     *
     * @return
     */
    int output5V();
}
```

```java
/**
 * 类适配器
 * 适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 */
public class PowerAdapter extends AC220 implements DC5 {
    /**
     * 输出5V直流电
     *
     * @return
     */
    @Override
    public int output5V() {
        int output = output220V();
        return (output / 44);
    }
}
```
```java
/**
 * 测试类适配器
 */
public class TestClassAdapter {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter();
        System.out.println("输出电流：" + dc5.output5V() + "V");
    }
}
```
- 适配器模式之对象适配器模式

- 实现方式：让Adapter持有Adaptee类的实例，然后再实现Target接口，以这种持有对象的方式来实现适配器功能。
- 优点：根据合成复用原则，使用组合替代继承， 所以它解决了类适配器必须继承Adaptee的局限性问题，也不再要求Target必须是接口。使用成本更低，更灵活。
- 实例：手机充电需要将220V的交流电转化为手机锂电池需要的5V直流电。使用电源适配器，将 AC220v ——> DC5V。
- 类图：

![object_adapter](E:\IdeaProjects\java-learning\img\object_adapter.png)

- 代码：

```java
/**
 * 源角色(Adaptee)：现在需要适配的接口。
 */
public class AC220 {
    /**
     * 输出220V交流电
     *
     * @return
     */
    public int output220V() {
        int output = 220;
        return output;
    }
}
```

```java
/**
 * 目标角色(Target)：这就是所期待得到的接口。
 */
public interface DC5 {
    /**
     * 输出5V直流电（期待得到的接口）
     *
     * @return
     */
    int output5V();
}
```

```java
/**
 * 对象适配器
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    /**
     * 输出5V直流电
     *
     * @return
     */
    @Override
    public int output5V() {
        int output = this.ac220.output220V();
        return (output / 44);
    }
}
```

```java
/**
 * 测试对象适配器
 */
public class TestObjectAdapter {
    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        PowerAdapter powerAdapter = new PowerAdapter(ac220);
        System.out.println("输出电流：" + powerAdapter.output5V() + "V");
    }
}
```

- 适配器模式之接口适配器模式

- 实现方式：当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现（空方法），那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求。
- 实例：接口是万能适配器，有多种方法，而我们只关注5V的适配，使用抽象类为每个方法提供默认实现，然后使用子类只重写输出5V电流的方法。
- 类图

![interface_adapter](E:\IdeaProjects\java-learning\img\interface_adapter.png)

- 代码：

```java
/**
 * 源角色(Adaptee)：现在需要适配的接口。
 */
public class AC220 {
    /**
     * 输出220V交流电
     *
     * @return
     */
    public int output220V() {
        int output = 220;
        return output;
    }
}
```

```java
/**
 * 目标角色接口（提供多个接口）
 */
public interface DC {
    int output5V();

    int output9V();

    int output12V();

    int output24V();
}
```

```java
/**
 * 抽象适配器：接口所有方法空实现
 */
public abstract class PowerAdapter implements DC {
    protected AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        return 0;
    }

    @Override
    public int output9V() {
        return 0;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }
}
```

```java
/**
 * 抽象适配器子类：只重载需要的方法
 */
public class Power5VAdapter extends PowerAdapter {

    public Power5VAdapter(AC220 ac220) {
        super(ac220);
    }

    @Override
    public int output5V() {
        int output = 0;
        if (ac220 != null) {
            output = ac220.output220V() / 44;
        }
        return output;
    }
}
```

```java

/**
 * 测试接口适配器
 */
public class TestInterfaceAdapter {
    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        Power5VAdapter power5VAdapter = new Power5VAdapter(ac220);
        System.out.println("输出电流：" + power5VAdapter.output5V() + "V");

    }
}
```

- 装饰器模式

- 定义：装饰器模式以对客户透明的方式动态的给一个对象附加上更多的责任。换言之，客户端并不会觉得对象在装饰前和装饰后有什么不同。
- 优点：1) 装饰模式与继承关系的目的都是要扩展对象的功能，但是装饰模式可以提供比继承更多的灵活性。2) 通过使用不同的具体装饰类以及这些装饰类的排列组合，设计师可以创造出很多不同行为的组合。
- 缺点：使用装饰模式会产生比使用继承关系更多的对象。更多的对象会使得查错变得困难，特别是这些对象看上去都很相像。
- 博客：https://www.jianshu.com/p/10a77d91c93f
- 实例：为星巴兹咖啡连锁店设计饮料菜单，咖啡可加的调料有豆浆、牛奶、摩卡等。可在咖啡的基础上加入不同的调料，星巴兹会根据所加的调料收取不同的费用，要注意到，以后可能有新的调料被加入进来供顾客选择。并且本店现有DarkRoast（深焙）、HouseBlend（综合）、Decaf（低咖啡因）及Espresso（浓咖啡）四种类型的咖啡，而且以后可能会添加新的咖啡种类。使用装饰者模式，四种咖啡为具体组件，调料为具体装饰者。
- 类图：

![decorator__pattern](E:\IdeaProjects\java-learning\img\decorator__pattern.png)

- 代码：

```java
/**
 * 抽象组件:需要装饰的抽象对象(接口或抽象父类) - 饮料
 */
abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
```

```java
/**
 * 具体组件:需要装饰的对象 - 无因咖啡
 */
class Decaf extends Beverage {
    public Decaf() {
        super("无因咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}

```

```java
/**
 * 具体组件:需要装饰的对象 - 焦糖咖啡
 */
class DarkRoast extends Beverage {
    public DarkRoast() {
        super("焦糖咖啡");
    }

    @Override
    public double cost() {
        return 3;
    }
}
```

```java
/**
 * 具体组件:需要装饰的对象 - 浓缩咖啡
 */
class Espresso extends Beverage {
    public Espresso() {
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 2;
    }
}
```

```java
/**
 * 具体组件:需要装饰的对象 - 混合咖啡
 */
class HouseBlend extends Beverage {
    public HouseBlend() {
        super("混合咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}

```

```java
/**
 * 抽象装饰类:包含了对抽象组件的引用以及装饰者共有的方法 - 调料
 */
abstract class Condiment extends Beverage {
    //让调料类关联饮料类
    protected Beverage beverage;

    public Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }
}
```

```java
/**
 * 具体装饰类:被装饰的对象 - 牛奶
 */
class Milk extends Condiment {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 牛奶 ";
    }
}
```

```java
/**
 * 具体装饰类:被装饰的对象 - 摩卡
 */
class Mocha extends Condiment {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.4;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 摩卡 ";
    }
}
```

```java
/**
 * 具体装饰类:被装饰的对象 - 豆浆
 */
class Soy extends Condiment {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.3;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 豆浆 ";
    }
}
```

```java
/**
 * 测试装饰器
 */
public class TestDecorator {
    public static void main(String[] args) {
        Beverage b1 = new Decaf();
        Beverage b2 = new Milk(b1);
        Beverage b3 = new Mocha(b2);
        Beverage b4 = new Soy(b3);
        Beverage b5 = new Soy(b4);
        System.out.println(b5.getDescription() + b5.cost());
    }
}
```

3. 外观模式
- 定义：外观模式通过定义一个一致的接口，用以屏蔽内部子系统的细节，使得调用端只需跟这个接口发生调用，而无需关心这个子系统的内部细节。

- 优点：1) 外观模式对外屏蔽了子系统的细节，因此外观模式降低了客户端对子系统使用的复杂性。2) 外观模式对客户端与子系统的耦合关系，让子系统内部的模块更易维护和扩展。3) 通过合理的使用外观模式，可以帮我们更好的划分访问的层次。4) 当系统需要进行分层设计时，可以考虑使用Facade模式

- 缺点：不能过多的或者不合理的使用外观模式，使用外观模式好，还是直接调用模块好。要以让系统有层次，利于维护为目的。

- 与适配器模式的区别：适配器模式是将一个对象包装起来以改变其接口，而外观是将一群对象 ”包装“起来以简化其接口。它们的意图是不一样的，适配器是将接口转换为不同接口，而外观模式是提供一个统一的接口来简化接口。

- 博客：https://hanchao.blog.csdn.net/article/details/97616272

- 实例：瀑布模型软件开发场景：瀑布模型软件开发过程：制定计划、需求分析、软件设计、程序编写、软件测试和运行维护。
制定计划的主要执行者：产品经理。
需求分析的主要执行者：产品经理。
软件设计的主要执行者：开发经理。
程序编写的主要执行者：开发攻城狮，可能有多人。
软件测试的主要执行者：测试攻城狮，可能有多人。
运行维护的主要执行者：运维攻城狮，可能有多人。

- 类图：

![facade_pattern](E:\IdeaProjects\java-learning\img\facade_pattern.png)

- 代码：

```java
/**
 * 参与者抽象
 */
public class AbstractWorker {
    /**
     * 姓名
     */
    private String name;

    /**
     * 职位
     */
    private String job;

    public AbstractWorker(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "AbstractWorker{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
```

```java
/**
 * 项目经理
 */
public class ProjectManager extends AbstractWorker {
    public ProjectManager(String name) {
        super(name, "项目经理");
    }

    public void makeProjectPlan() {
        System.out.println(super.getName() + " | " + super.getJob() + " 制定了项目计划...");
    }

    public void analysisRequirement() {
        System.out.println(super.getName() + " | " + super.getJob() + " 进行了需求分析...");
    }
}
```

```java
/**
 * 开发经理
 */
public class DevelopManager extends AbstractWorker {
    public DevelopManager(String name) {
        super(name, "开发经理");
    }

    public void makeDevelopmentPlan() {
        System.out.println(super.getName() + " | " + super.getJob() + " 制定了研发计划...");
    }

}
```

```java
/**
 * 研发工程师
 */
public class DevelopmentEngineer extends AbstractWorker {
    public DevelopmentEngineer(String name, String job) {
        super(name, job);
    }

    public void develop() {
        System.out.println(super.getName() + " | " + super.getJob() + " 开始进行研发...");
    }

}
```

```java
/**
 * 测试工程师
 */
public class QualityAssurance extends AbstractWorker {
    public QualityAssurance(String name) {
        super(name, "测试攻城狮");
    }

    public void test() {
        System.out.println(super.getName() + " | " + super.getJob() + " 开始进行测试...");
    }
}

```

```java
/**
 * 运维工程师
 */
public class Operations extends AbstractWorker {
    public Operations(String name) {
        super(name, "运维攻城狮");
    }

    public void operationAndMaintenance() {
        System.out.println(super.getName() + " | " + super.getJob() + " 持续进行运维...");
    }

}
```

```java
/**
 * 外观类
 */
public class Project {
    /**
     * 项目名称
     */
    private String name;

    /**
     * 产品经理
     */
    private ProjectManager projectManager;

    /**
     * 开发经理
     */
    private DevelopManager developManager;

    /**
     * 开发攻城狮们
     */
    private List<DevelopmentEngineer> engineerList;

    /**
     * 测试攻城狮
     */
    private List<QualityAssurance> assuranceList;

    /**
     * 运维攻城狮
     */
    private List<Operations> operationsList;

    public Project(String name, ProjectManager projectManager, DevelopManager developManager, List<DevelopmentEngineer> engineerList, List<QualityAssurance> assuranceList, List<Operations> operationsList) {
        this.name = name;
        this.projectManager = projectManager;
        this.developManager = developManager;
        this.engineerList = engineerList;
        this.assuranceList = assuranceList;
        this.operationsList = operationsList;
    }

    /**
     * 开发过程
     */
    public void developProject() {
        System.out.println(this.name + " 项目启动...");
        System.out.println("-----------------------------");
        //指定计划
        projectManager.makeProjectPlan();

        //需求分析
        projectManager.analysisRequirement();

        //软件设计
        developManager.makeDevelopmentPlan();

        //程序编写
        engineerList.forEach(DevelopmentEngineer::develop);

        //软件测试
        assuranceList.forEach(QualityAssurance::test);

        //运行维护
        operationsList.forEach(Operations::operationAndMaintenance);

        System.out.println("-----------------------------");
        System.out.println(this.name + " 项目完成...");
    }
}
```

```java
/**
 * 测试外观模式
 */
public class TestFacade {
    public static void main(String[] args) {
        //产品经理
        ProjectManager projectManager = new ProjectManager("扫地僧");
        //开发经理
        DevelopManager developManager = new DevelopManager("张三丰");
        //开发攻城狮们
        List<DevelopmentEngineer> engineerList = new ArrayList<>();
        engineerList.add(new DevelopmentEngineer("令狐冲", "前端开发攻城狮"));
        engineerList.add(new DevelopmentEngineer("张无忌", "后端开发攻城狮"));

        //测试攻城狮们
        List<QualityAssurance> assuranceList = new ArrayList<>();
        assuranceList.add(new QualityAssurance("小龙女"));

        //运维攻城狮们
        List<Operations> operationsList = new ArrayList<>();
        operationsList.add(new Operations("鸠摩智"));
        operationsList.add(new Operations("欧阳锋"));

        //项目一
        new Project("武林群侠传项目", projectManager, developManager, engineerList, assuranceList, operationsList).developProject();

        System.out.println("=============================");

        //项目二
        new Project("入职项目", projectManager, developManager,
                Collections.singletonList(new DevelopmentEngineer("小虾米", "前端开发攻城狮")),
                Collections.singletonList(new QualityAssurance("小虾米")),
                Collections.singletonList(new Operations("小虾米"))).developProject();
    }
}
```

4. 代理模式
- 定义：代理模式是一种设计模式，提供了对目标对象额外的访问方式，即通过代理对象访问目标对象，这样可以在不修改原目标对象的前提下，提供额外的功能操作，扩展目标对象的功能。

- 代理模式之静态代理

- 优点：可以在不修改目标对象的前提下扩展目标对象的功能。

- 缺点：1）冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。2）不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。

- 实例：以发送信息服务为例，在发送信息前后添加额外的操作。

- 类图：

![static_proxy](E:\IdeaProjects\java-learning\img\static_proxy.png)

- 代码：

```java
/**
 * 发送短信的接口
 */
public interface SmsService {

    /**
     * 发送短信的方法
     *
     * @param message
     * @return
     */
    String sendMsg(String message);
}
```

```java
/**
 * 发送短信接口的实现类
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String sendMsg(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
```

```java
/**
 * 发送短息代理类：同样实现发送短信的接口，并注入发送短信的类
 */
public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String sendMsg(String message) {
        //调用方法之前,添加自己的操作
        System.out.println("do something before send message.");
        smsService.sendMsg(message);
        System.out.println("do something after send message.");
        return null;
    }
}
```

```java
/**
 * 测试静态代理
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.sendMsg("java");
    }
}

```

- 代理模式之动态代理

- 实现方式：动态代理利用了JDKAPI，动态代理类的字节码在程序运行时由java反射机制动态生成，动态地在内存中构建代理对象，从而实现对目标对象的代理功能。动态代理又被称为JDK代理或接口代理。

- 优点：1）动态代理必须实现InvocationHandler接口，通过反射代理方法，比较消耗系统性能，但可以减少代理类的数量，使用更灵活。2）动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性，因为java反射机制可以生成任意类型的动态代理类。

- 缺点：动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。

- 实例：以发送信息服务为例，在发送信息前后添加额外的操作。在运行时动态生成类字节码，并加载到JVM中。

- 类图：

![dynamic_proxy](E:\IdeaProjects\java-learning\img\dynamic_proxy.png)

- 代码：

```java
/**
 * 发送短信的接口
 */
public interface SmsService {

    /**
     * 发送短信的方法
     *
     * @param message
     * @return
     */
    String sendMsg(String message);
}
```

```java
/**
 * 发送短信接口的实现类
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String sendMsg(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

```

```java
/**
 * 动态代理类
 */
public class DebugInvocationHandler implements InvocationHandler {
    //代理类真实对象
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前,添加自己的操作
        System.out.println("do something before send message.");
        Object res = method.invoke(target, args);//通过反射调用方法
        //调用方法之后添加操作
        System.out.println("do something after send message.");
        return res;
    }
}
```

```java
/**
 * 代理对象工厂类
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        //三个参数：
        // 目标类的类加载器
        // 代理需要实现的接口，可指定多个
        // 代理对象对应的自定义 InvocationHandler
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target));
    }
}

```

```java
/**
 * 测试动态代理
 */
public class TestDynamicProxy {
    public static void main(String[] args) {

        SmsService smsService = new SmsServiceImpl();
        SmsService smsProxy = (SmsService) JdkProxyFactory.getProxy(smsService);
        smsProxy.sendMsg("java");

    }
}
```

- 代理模式之CGLIB代理
- 优点：cglib代理无需实现接口，通过生成类字节码实现代理，比反射稍快，不存在性能问题
- 缺点：cglib会继承目标对象，需要重写方法，所以目标对象不能为final类。
- 博客：https://segmentfault.com/a/1190000011291179
- 实例：以cglib的方式进行具体类的代理。
- 类图：

![cglib_proxy](E:\IdeaProjects\java-learning\img\cglib_proxy.png)

- 代码：（需要引入CGLIB第三方库）

```java
/**
 * 发送短信类
 */
public class AliSmsService {
    public String sendMsg(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

```

```java
/**
 * 自定义 MethodInterceptor（方法拦截器）
 */
public class DebugMethodInterceptor implements MethodInterceptor {


    /**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        //调用方法之前,添加自己的操作
        System.out.println("do something before send message.");
        Object object = methodProxy.invokeSuper(o, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("do something after send message.");
        return object;
    }
}
```

```java
/**
 * 代理类
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
```

```java
/**
 * 测试CGLIB代理
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        AliSmsService aliSmsService = new AliSmsService();
        AliSmsService aliSmsProxy = (AliSmsService) CglibProxyFactory.getProxy(aliSmsService.getClass());
        aliSmsProxy.sendMsg("java");

    }
}
```

- 行为型模式

1. 策略模式
- 定义：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。

- 优点：（1）策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。恰当使用继承可以把公共的代码移到父类里面，从而避免代码重复。（2）使用策略模式可以避免使用多重条件(if-else)语句。多重条件语句不易维护，它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，统统列在一个多重条件语句里面，比使用继承的办法还要原始和落后。

- 缺点：（1）客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。换言之，策略模式只适用于客户端知道算法或行为的情况。（2）由于策略模式把每个具体的策略实现都单独封装成为类，如果备选的策略很多的话，那么对象的数目就会很可观。

- 博客：https://blog.csdn.net/hanchao5272/article/details/96480255、https://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html

- 实例：购物车支付策略场景：每个商品都有名称和价钱。购物车可以添加多个商品。购物车支付方式暂时只支持支付宝和微信，但是后期可能会增减更多支付方式。

- 类图：

![strategy_pattern](E:\IdeaProjects\java-learning\img\strategy_pattern.png)

- 代码：

```java
/**
 * 商品类
 */
public class Goods {
    private String name;
    private Double price;

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
```

```java
/**
 * 支付策略接口
 */
public interface PayStrategy {

    /**
     * 支付
     *
     * @param cost
     */
    void pay(Double cost);
}
```

```java
/**
 * 具体支付策略 - 支付宝
 */
public class AliPayStrategy implements PayStrategy {
    @Override
    public void pay(Double cost) {
        System.out.println("使用支付宝支付了 " + cost + " 元");
    }
}
```

```java
/**
 * 具体支付策略 - 银联
 */
public class UnionPayStrategy implements PayStrategy {
    @Override
    public void pay(Double cost) {
        System.out.println("使用银联支付了 " + cost + "元");
    }
}
```

```java
/**
 * 具体支付策略 - 微信
 */
public class WechatPayStrategy implements PayStrategy {
    @Override
    public void pay(Double cost) {
        System.out.println("使用微信支付了 " + cost + " 元");
    }
}
```

```java
/**
 * @author wmy
 * @date 2021/8/11 17:16
 */

/**
 * 购物车
 */
public class StrategyShoppingCart {
    /**
     * 商品列表
     */
    private List<Goods> goodsList;
    /**
     * 支付策略
     */
    private PayStrategy payStrategy;

    public StrategyShoppingCart() {
        this.goodsList = new ArrayList<>();
    }

    /**
     * 添加商品
     *
     * @param goods
     */
    public void addGoods(Goods goods) {
        this.goodsList.add(goods);
    }

    /**
     * 计算总价
     *
     * @return
     */
    public Double calcCost() {
        Double totalCost = 0.0;
        for (Goods goods : this.goodsList) {
            totalCost += goods.getPrice();
        }
        return totalCost;
    }

    /**
     * 选择支付策略
     *
     * @param payStrategy
     */
    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 支付
     */
    public void pay() {
        this.payStrategy.pay(this.calcCost());
    }
}

```

```java
/**
 * 测试策略模式
 */
public class TestStrategy {
    public static void main(String[] args) {
        //支付宝支付
        StrategyShoppingCart strategyShoppingCart1 = new StrategyShoppingCart();
        strategyShoppingCart1.addGoods(new Goods("一箱牛奶", 34.55));
        strategyShoppingCart1.addGoods(new Goods("一瓶白酒", 250.50));
        strategyShoppingCart1.setPayStrategy(new AliPayStrategy());
        strategyShoppingCart1.pay();

        //银联支付
        StrategyShoppingCart strategyShoppingCart2 = new StrategyShoppingCart();
        strategyShoppingCart2.addGoods(new Goods("一箱牛奶", 34.55));
        strategyShoppingCart2.addGoods(new Goods("一瓶啤酒", 3.50));
        strategyShoppingCart2.setPayStrategy(new UnionPayStrategy());
        strategyShoppingCart2.pay();
    }
}
```

2. 观察者模式

- 定义：又叫发布-订阅模式（Publish/Subscribe），定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。

- 优点：观察者模式设计后，会以集合的方式来管理用户(Observer)，包括注册，移除和通知。这样，增加观察者(这里可以理解成一个新的公告板)，就不需要去修改核心类Newspaper不会修改代码，遵守了OCP原则。

- 缺点：在应用观察者模式时需要考虑一下开发效率和运行效率的问题，程序中包括一个被观察者、多个观察者，开发、调试等内容会比较复杂，而且在java中消息的通知一般是顺序执行，那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异步实现。

- 博客：https://hanchao.blog.csdn.net/article/details/97149607、https://www.cnblogs.com/adamjwh/p/10913660.html

- 实例：报纸订阅场景：用户可以订阅报纸，也可以取消订阅报纸。可以将报纸发布给所有订阅它的用户。

- 类图：

![observer_pattern](E:\IdeaProjects\java-learning\img\observer_pattern.png)

- 代码：

```java
/**
 * 抽象观察者
 */
public interface Observer {
    /**
     * 消息更新
     *
     * @param message
     */
    public void update(String message);

}
```

```java
/**
 * 具体观察者：订阅报纸的用户
 */
public class User implements Observer {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 接收报纸
     *
     * @param message
     */
    @Override
    public void update(String message) {
        System.out.println(this.name + " 接收报纸信息: " + message);
    }
}
```

```java
/**
 * 主题抽象
 */
public interface Subject {
    /**
     * 注册
     */
    void register(Observer observer);

    /**
     * 取消注册
     */
    void remove(Observer observer);

    /**
     * 通知观察者们
     */
    void notifyObservers();

}
```

```java

/**
 * 主题实现
 */
public class Newspaper implements Subject {
    /**
     * 订阅者列表
     */
    private List<Observer> observerList;

    /**
     * 报纸信息
     */
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public Newspaper() {
        this.observerList = new ArrayList<>();
    }

    /**
     * 订阅
     *
     * @param observer
     */
    @Override
    public void register(Observer observer) {
        this.observerList.add(observer);

    }

    /**
     * 取消订阅
     *
     * @param observer
     */
    @Override
    public void remove(Observer observer) {
        this.observerList.remove(observer);
    }

    /**
     * 向所有订阅者邮寄报纸
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
```

```java
/**
 * 测试观察者模式
 */
public class TestObserver {
    public static void main(String[] args) {
        //Lily,Jack订阅报纸
        Newspaper newspaper = new Newspaper();
        User lily = new User(1, "Lily");
        User jack = new User(2, "Jack");
        newspaper.register(lily);
        newspaper.register(jack);

        //邮寄报纸
        newspaper.setMessage("中国青年报");
        newspaper.notifyObservers();
        System.out.println("--------------------------------------");

        //jack取消了订阅报纸
        newspaper.remove(jack);
        //邮寄报纸
        newspaper.setMessage("环球时报");
        newspaper.notifyObservers();
    }
}
```

3. 责任链模式
- 定义：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。

- 优点：1）降低耦合度。它将请求的发送者和接收者解耦。 2）简化了对象。使得对象不需要知道链的结构。 3）增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任。 4）增加新的请求处理类很方便。

- 缺点：1）不能保证请求一定被接收。 2）系统性能将受到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。 3）可能不容易观察运行时的特征，有碍于除错。

- 博客：https://hanchao.blog.csdn.net/article/details/97285508

- 实例：多轮面试场景：招聘流程：笔试面试ExamInterview、技术面试TechnicalInterview、HR面试HRInterview。每轮面试的内容各不相同，如果不能达到本轮面试标准，则被淘汰。需求变化：有可能添加CEO面试CEOInterview，减少笔试等等；针对不同的求职者可能有不同的面试安排。

- 类图：

![chain_of_responsibility](E:\IdeaProjects\java-learning\img\chain_of_responsibility.png)

- 代码：

```java
/**
 * 抽象面试类
 */
public abstract class Interview {

    /**
     * 下一轮面试（可类比链表的下一个节点）
     */
    private Interview interview;

    public Interview(Interview interview) {
        this.interview = interview;
    }

    public Interview getInterview() {
        return interview;
    }

    /**
     * 进行面试
     */
    public abstract String runInterview(String name);
}
```

```java
/**
 * 笔试
 */
public class ExamInterview extends Interview {

    public ExamInterview(Interview interview) {
        super(interview);
    }

    @Override
    public String runInterview(String name) {
        System.out.println(name + "开始参加笔试");
        System.out.println("此轮笔试共计10道选择题，5道机试题，共计100分，答题时间60分钟。");
        int score = new Random().nextInt(50) + 50;
        if (score >= 60) {
            System.out.println(name + " 笔试得分为 " + score + " 通过了笔试。");
        } else {
            System.out.println(name + " 笔试得分为 " + score + ", 未通过笔试。");
            return "面试结果：未通过笔试";
        }
        System.out.println(name + " 进入下一轮面试。");
        System.out.println("--------------------------------");
        return super.getInterview().runInterview(name);
    }
}
```

```java
/**
 * 技术面试
 */
public class TechnicalInterview extends Interview {
    public TechnicalInterview(Interview interview) {
        super(interview);
    }

    @Override
    public String runInterview(String name) {
        //技术面试
        System.out.println(name + " 开始参加技术面试");
        System.out.println("技术面试官先问了一些基础知识");
        boolean pass = new Random().nextBoolean();
        if (pass) {
            System.out.println(name + " 基础知识回答得很完美，继续技术面试。");
        } else {
            System.out.println(name + " 基础知识掌握的很差，未通过技术面试。");
            return "面试结果：未通过技术面试";
        }
        System.out.println("技术面试官又问了一些高级知识");
        pass = new Random().nextBoolean();
        if (pass) {
            System.out.println(name + " 高级知识回答得马马虎虎，继续技术面试。");
        } else {
            System.out.println(name + " 高级知识简直是不懂装通，未通过技术面试。");
            return "面试结果：未通过技术面试";
        }

        System.out.println(name + " 进入下一轮面试。");
        System.out.println("--------------------------------");
        return super.getInterview().runInterview(name);
    }
}
```

```java
/**
 * HR面试
 */
public class HRInterview extends Interview {

    public HRInterview(Interview interview) {
        super(interview);
    }

    @Override
    public String runInterview(String name) {
        //HR面试
        System.out.println(name + " 开始参加HR面试");
        System.out.println("HR先聊了聊公司的背景、现状、前景...");
        System.out.println(name + " 反映很满意。");
        System.out.println("HR开始谈工资。");
        int score = new Random().nextInt(10) + 20;
        if (score <= 25) {
            System.out.println(name + " 期望工资涨幅为" + score + "%，在HR承受范围内，通过了面试。");
        } else {
            System.out.println(name + " 期望工资涨幅为" + score + "%，超出HR承受范围内，未通过面试。");
            return "面试结果：未通过HR面试";
        }
        System.out.println(name + " 进入下一轮面试。");
        System.out.println("--------------------------------");
        return super.getInterview().runInterview(name);

    }
}
```

```java
/**
 * 责任节点，通过面试
 */
public class PassInterview extends Interview {
    public PassInterview() {
        super(null);
    }

    @Override
    public String runInterview(String name) {
        System.out.println(name + " 通过了所有面试，恭喜你！");
        return "通过了所有面试，恭喜你！";
    }
}
```

```java
/**
 * 测试责任链模式
 */
public class TestChainOfResponsibility {

    public static void main(String[] args) {
        //1.普通求职者王五的面试过程
        String name1 = "王五";
        new ExamInterview(new TechnicalInterview(new HRInterview(new PassInterview()))).runInterview(name1);
        System.out.println();

        //1.高级求职者张三的面试过程
        String name2 = "张三";
        new TechnicalInterview(new HRInterview(new PassInterview())).runInterview(name2);

    }
}
```

4. 状态模式
- 定义：允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。

- 优点：1) 每个状态都是一个子类，只要增加状态就要增加子类，修改状态，只修改一个子类即可。符合“开闭原则”。容易增删状态。2）结构清晰，避免了过多的switch...case或者if...else语句的使用，避免了程序的复杂性，提高可维护性。

- 缺点：会产生很多类。每个状态都要一个对应的类，当状态过多时会产生很多类，加大维护难度。

- 博客：https://blog.csdn.net/qq_31984879/article/details/85199258?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-1.control&spm=1001.2101.3001.4242

- 实例：购物场景：在购物网站进行购物时，订单会产生几种状况：已下单、已付款、送货中、确定收货等状态。所以系统会判断该订单的状态，不管是哪种状态都应给出对应的操作，这就是状态。

- 类图：

![state](E:\IdeaProjects\java-learning\img\state_pattern.png)

- 代码：

```java
/**
 * 状态接口
 */
public interface State {
    void handle();
}
```

```java
/**
 * 具体状态角色(ConcreteState):下单状态
 */
public class Booked implements State {
    @Override
    public void handle() {
        System.out.println("您已下单！");
    }
}
```

```java
/**
 * 具体状态角色(ConcreteState):支付状态
 */
public class Payed implements State {
    @Override
    public void handle() {
        System.out.println("您已支付订单！");
    }
}
```

```java
/**
 * 具体状态角色(ConcreteState):订单发货状态
 */
public class Sended implements State {
    @Override
    public void handle() {
        System.out.println("订单已发货！");
    }
}
```

```java
/**
 * 具体状态角色(ConcreteState):订单运送状态
 */
public class InWay implements State {
    @Override
    public void handle() {
        System.out.println("订单正在运送中！");
    }
}
```

```java
/**
 * 具体状态角色(ConcreteState):订单签收状态
 */
public class Recieved implements State {
    @Override
    public void handle() {
        System.out.println("订单已签收！");
    }
}
```

```java
/**
 * 定义一个环境类来维护State接口
 */
public class Context {
    private State state;

    public Context() {
    }

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        System.out.println("订单信息已更新！");
        this.state = state;
        this.state.handle();
    }
}
```

```java
/**
 * 测试状态模式
 */
public class TestState {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new Booked());
        context.setState(new Payed());
        context.setState(new Sended());
        context.setState(new InWay());
        context.setState(new Recieved());
    }
}
```

5. 命令模式
- 定义：命令模式把一个请求或者操作封装到一个对象中。命令模式允许系统使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。

- 优点： 1）将发起请求的对象与执行请求的对象解耦。发起请求的对象是调用者，调用者只要调用命令对象的execute()方法就可以让接收者工作，而不必知道具体的接收者对象是谁、是如何实现的，命令对象会负责让接收者执行请求的动作，命令对象起到了纽带桥梁的作用。2) 容易设计一个命令队列。只要把命令对象放到列队，就可以多线程的执行命令。3) 容易实现对请求的撤销和重做。

- 缺点：可能导致某些系统有过多的具体命令类，增加了系统的复杂度。

- 博客：https://segmentfault.com/a/1190000012203360

- 实例：以MusicPlayer（音乐播放器）为案例，播放器有播放（play），跳过（skip），停止（stop）等功能，是一种比较典型的命令模式。

- 类图：

![command_pattern](E:\IdeaProjects\java-learning\img\command_pattern.png)

- 代码：

```java
/**
 * 命令接口类
 */
public interface Command {

    /**
     * 执行命令
     */
    void execute();

}
```

```java
/**
 * 命令实现类：播放
 */
public class PlayCommand implements Command {

    /**
     * 接收者
     */
    private MusicPlayer musicPlayer;

    public PlayCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.play();
    }
}
```

```java
/**
 * 命令实现类：跳过
 */
public class SkipCommand implements Command {

    /**
     * 接收者
     */
    private MusicPlayer musicPlayer;

    public SkipCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.skip();
    }
}
```

```java
/**
 * 命令实现类：暂停
 */
public class StopCommand implements Command {

    /**
     * 接收者
     */
    private MusicPlayer musicPlayer;

    public StopCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.stop();
    }
}
```

```java
/**
 * 请求者角色,接收客户端发送过来的指令
 */

public class MusicInvoker {
    private Command playCommand;
    private Command skipCommand;
    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setSkipCommand(Command skipCommand) {
        this.skipCommand = skipCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    public void play() {
        playCommand.execute();
    }

    public void skip() {
        skipCommand.execute();
    }

    public void stop() {
        stopCommand.execute();
    }
}
```

```java
/**
 * 测试命令模式
 */
public class TestCommand {
    public static void main(String[] args) {
        // 创建 接收者
        MusicPlayer musicPlayer = new MusicPlayer();
        // 创建命令
        Command playCommand = new PlayCommand(musicPlayer);
        Command skipCommand = new SkipCommand(musicPlayer);
        Command stopCommand = new StopCommand(musicPlayer);
        // 创建命令请求者
        MusicInvoker invoker = new MusicInvoker();
        invoker.setPlayCommand(playCommand);
        invoker.setSkipCommand(skipCommand);
        invoker.setStopCommand(stopCommand);
        // 测试
        invoker.play();
        invoker.skip();
        invoker.stop();
        invoker.play();
        invoker.stop();
    }
}
```

5. 模板方法模式
- 定义：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法模式使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
- 优点：1）封装不变部分，扩展可变部分。2）提取公共代码，便于维护。3）行为由父类控制，子类实现。
- 缺点：每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
- 博客：https://blog.csdn.net/pange1991/article/details/81183122
- 实例：创建一个定义操作的 *Game* 抽象类，其中，模板方法设置为 final，这样它就不会被重写。*Cricket* 和 *Football* 是扩展了 *Game* 的实体类，它们重写了抽象类的方法。
- 类图：

![template_pattern](E:\IdeaProjects\java-learning\img\template_pattern.png)

- 代码：

```java
/**
 * 抽象模板 - 游戏
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板方法
    public final void play() {

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }

}
```

```java
/**
 * 具体模板类 - 打篮球游戏
 */
public class Basketball extends Game {
    @Override
    void endPlay() {
        System.out.println("Basketball Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Basketball Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Basketball Game Started. Enjoy the game!");
    }

}
```

```java
/**
 * 具体模板类 - 踢足球游戏
 */
public class Football extends Game {
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

}
```

```java
/**
 * 测试模板方法模式
 */
public class TestTemplate {
    public static void main(String[] args) {

        Game game = new Basketball();
        game.play();
        System.out.println();
        game = new Football();
        game.play();

    }
}
```

