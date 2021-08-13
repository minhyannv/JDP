package jdp.singleton;

/**
 * @author wmy
 * @date 2021/8/10 11:01
 */

public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton03 instance1 = Singleton03.getInstance();
        Singleton03 instance2 = Singleton03.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

//懒汉式（使用时才初始化）
//优点：起到了lazy loading的效果，但是只能在单线程下使用
//缺点：多线程下可能会产生多个实例，（因为可能有多个线程进入if方法）所以实际开发中不要使用这种方式
class Singleton03 {
    private static Singleton03 instance;

    //1.构造器私有化
    private Singleton03() {
    }

    //2.提供静态私有方法，当使用该方法时，才去创建instance
    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;

    }

}
