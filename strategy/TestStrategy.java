package jdp.strategy;

/**
 * @author wmy
 * @date 2021/8/11 17:23
 */

/**
 * 测试策略模式
 */
public class TestStrategy {
    public static void main(String[] args) {
        //支付宝支付
        StrategyShoppingCart strategyShoppingCart1 = new StrategyShoppingCart();
        strategyShoppingCart1.addGoods(new Goods("一箱牛奶", 34.55));
        strategyShoppingCart1.addGoods(new Goods("一瓶白酒", 250.50));
        strategyShoppingCart1.setPayStrategy(new AliPayStrategy());
        strategyShoppingCart1.pay();

        //银联支付
        StrategyShoppingCart strategyShoppingCart2 = new StrategyShoppingCart();
        strategyShoppingCart2.addGoods(new Goods("一箱牛奶", 34.55));
        strategyShoppingCart2.addGoods(new Goods("一瓶啤酒", 3.50));
        strategyShoppingCart2.setPayStrategy(new UnionPayStrategy());
        strategyShoppingCart2.pay();
    }
}
