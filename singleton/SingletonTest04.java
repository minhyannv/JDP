package jdp.singleton;

/**
 * @author wmy
 * @date 2021/8/10 11:01
 */

public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton04 instance1 = Singleton04.getInstance();
        Singleton04 instance2 = Singleton04.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

//懒汉式线程安全，同步（使用时才初始化）
//优点：起到了lazy loading的效果
//缺点：方法加了锁效率太低
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
