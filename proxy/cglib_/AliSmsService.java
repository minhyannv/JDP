package jdp.proxy.cglib_;

import jdp.proxy.dynamic_.SmsService;

/**
 * @author wmy
 * @date 2021/8/5 15:42
 */

/**
 * 发送短信类
 */
public class AliSmsService {
    public String sendMsg(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
