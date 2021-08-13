package jdp.proxy.dynamic_;

import java.lang.reflect.Proxy;

/**
 * @author wmy
 * @date 2021/8/5 15:58
 */

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
