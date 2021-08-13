package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:34
 */

/**
 * 具体装饰类:被装饰的对象 - 豆浆
 */
class Soy extends Condiment {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.3;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + 豆浆 ";
    }
}