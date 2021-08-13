package jdp.proxy.static_;

/**
 * @author wmy
 * @date 2021/8/5 15:41
 */

/**
 * 发送短信的接口
 */
public interface SmsService {

    /**
     * 发送短信的方法
     *
     * @param message
     * @return
     */
    String sendMsg(String message);
}
