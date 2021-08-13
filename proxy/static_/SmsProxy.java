package jdp.proxy.static_;

import jdp.proxy.static_.SmsService;

/**
 * @author wmy
 * @date 2021/8/5 15:43
 */

/**
 * 发送短息代理类：同样实现发送短信的接口，并注入发送短信的类
 */
public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String sendMsg(String message) {
        //调用方法之前,添加自己的操作
        System.out.println("do something before send message.");
        smsService.sendMsg(message);
        System.out.println("do something after send message.");
        return null;
    }
}
