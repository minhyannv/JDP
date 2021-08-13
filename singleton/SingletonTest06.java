package jdp.singleton;

/**
 * @author wmy
 * @date 2021/8/10 11:01
 */

public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton06 instance1 = Singleton06.getInstance();
        Singleton06 instance2 = Singleton06.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

// 单例模式：静态内部类（推荐使用）
// 采用了类装载的机制来保证初始化实例时只有一个线程
// 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化
//时，调用getInstance方法，才会装载SingletonInstance类，
// 从而完成Singleton的实例化。
//优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
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
