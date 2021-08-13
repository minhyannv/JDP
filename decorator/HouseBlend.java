package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:34
 */

/**
 * 具体组件:需要装饰的对象 - 混合咖啡
 */
class HouseBlend extends Beverage {
    public HouseBlend() {
        super("混合咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}

