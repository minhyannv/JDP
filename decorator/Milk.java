package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:34
 */

/**
 * 具体装饰类:被装饰的对象 - 牛奶
 */
class Milk extends Condiment {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 牛奶 ";
    }
}

