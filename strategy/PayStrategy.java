package jdp.strategy;

/**
 * @author wmy
 * @date 2021/8/11 17:13
 */

/**
 * 支付策略接口
 */
public interface PayStrategy {

    /**
     * 支付
     *
     * @param cost
     */
    void pay(Double cost);
}
