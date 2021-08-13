package jdp.singleton;

/**
 * @author wmy
 * @date 2021/8/10 11:01
 */

public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton05 instance1 = Singleton05.getInstance();
        Singleton05 instance2 = Singleton05.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

// 单例模式：双重检查
//优点：起到了lazy loading的效果,线程安全
//缺点：方法加了锁效率太低
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
