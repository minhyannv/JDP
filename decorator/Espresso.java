package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:33
 */

/**
 * 具体组件:需要装饰的对象 - 浓缩咖啡
 */
class Espresso extends Beverage {
    public Espresso() {
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 2;
    }
}
