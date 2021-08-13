package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:33
 */

/**
 * 具体组件:需要装饰的对象 - 焦糖咖啡
 */
class DarkRoast extends Beverage {
    public DarkRoast() {
        super("焦糖咖啡");
    }

    @Override
    public double cost() {
        return 3;
    }
}
