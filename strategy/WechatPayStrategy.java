package jdp.strategy;

/**
 * @author wmy
 * @date 2021/8/11 17:14
 */

/**
 * 具体支付策略 - 微信
 */
public class WechatPayStrategy implements PayStrategy {
    @Override
    public void pay(Double cost) {
        System.out.println("使用微信支付了 " + cost + " 元");
    }
}
