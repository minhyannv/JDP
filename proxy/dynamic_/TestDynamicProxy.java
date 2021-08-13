package jdp.proxy.dynamic_;


import jdp.proxy.static_.SmsProxy;

/**
 * @author wmy
 * @date 2021/8/5 15:46
 */

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
