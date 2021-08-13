package jdp.strategy;

/**
 * 具体支付策略 - 银联
 */
public class UnionPayStrategy implements PayStrategy {
    @Override
    public void pay(Double cost) {
        System.out.println("使用银联支付了 " + cost + "元");
    }
}
