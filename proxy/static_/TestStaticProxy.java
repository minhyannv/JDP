package jdp.proxy.static_;

/**
 * @author wmy
 * @date 2021/8/5 15:46
 */
/**
 * 测试静态代理
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.sendMsg("java");
    }
}
