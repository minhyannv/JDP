package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:33
 */

/**
 * 具体组件:需要装饰的对象 - 无因咖啡
 */
class Decaf extends Beverage {
    public Decaf() {
        super("无因咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}
