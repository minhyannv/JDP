package jdp.proxy.static_;

import jdp.proxy.static_.SmsService;

/**
 * @author wmy
 * @date 2021/8/5 15:42
 */

/**
 * 发送短信接口的实现类
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String sendMsg(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
