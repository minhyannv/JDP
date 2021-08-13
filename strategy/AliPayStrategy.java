package jdp.strategy;

/**
 * @author wmy
 * @date 2021/8/11 17:14
 */

/**
 * 具体支付策略 - 支付宝
 */
public class AliPayStrategy implements PayStrategy {
    @Override
    public void pay(Double cost) {
        System.out.println("使用支付宝支付了 " + cost + " 元");
    }
}
