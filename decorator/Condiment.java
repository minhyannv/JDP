package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:34
 */

/**
 * 抽象装饰类:包含了对抽象组件的引用以及装饰者共有的方法 - 调料
 */
abstract class Condiment extends Beverage {
    //让调料类关联饮料类
    protected Beverage beverage;

    public Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }
}
