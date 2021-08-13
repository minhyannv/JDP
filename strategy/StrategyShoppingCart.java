package jdp.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmy
 * @date 2021/8/11 17:16
 */

/**
 * 购物车
 */
public class StrategyShoppingCart {
    /**
     * 商品列表
     */
    private List<Goods> goodsList;
    /**
     * 支付策略
     */
    private PayStrategy payStrategy;

    public StrategyShoppingCart() {
        this.goodsList = new ArrayList<>();
    }

    /**
     * 添加商品
     *
     * @param goods
     */
    public void addGoods(Goods goods) {
        this.goodsList.add(goods);
    }

    /**
     * 计算总价
     *
     * @return
     */
    public Double calcCost() {
        Double totalCost = 0.0;
        for (Goods goods : this.goodsList) {
            totalCost += goods.getPrice();
        }
        return totalCost;
    }

    /**
     * 选择支付策略
     *
     * @param payStrategy
     */
    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 支付
     */
    public void pay() {
        this.payStrategy.pay(this.calcCost());
    }
}
