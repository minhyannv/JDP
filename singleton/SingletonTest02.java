package jdp.singleton;

/**
 * @author wmy
 * @date 2021/8/10 11:01
 */

public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton02 instance1 = Singleton02.getInstance();
        Singleton02 instance2 = Singleton02.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

//饿汉式（静态代码块）
//优点：写法简单，类装载的时候完成实例化，避免线程同步问题
//缺点：如果从始至终未使用这个类，会造成内存浪费
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
