package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:35
 */

/**
 * 具体装饰类:被装饰的对象 - 摩卡
 */
class Mocha extends Condiment {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.4;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 摩卡 ";
    }
}