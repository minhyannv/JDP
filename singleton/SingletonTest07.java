package jdp.singleton;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @author wmy
 * @date 2021/8/10 11:01
 */

public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton07 instance1 = Singleton07.INSTANCE;
        Singleton07 instance2 = Singleton07.INSTANCE;
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        instance1.method();
        instance2.method();
    }
}

// 单例模式：枚举(推荐使用)
//优点：这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，
// 而且还能防止反序列化重新创建新的对象。
enum Singleton07 {
    //属性
    INSTANCE;
    //方法
    public void method() {
        System.out.println("run method...");
    }
}
