package jdp.proxy.dynamic_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wmy
 * @date 2021/8/5 15:54
 */

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
