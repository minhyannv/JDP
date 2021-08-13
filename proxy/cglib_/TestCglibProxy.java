package jdp.proxy.cglib_;


/**
 * @author wmy
 * @date 2021/8/5 15:46
 */

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
