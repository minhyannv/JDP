package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/12 14:32
 */

/**
 * 抽象组件:需要装饰的抽象对象(接口或抽象父类) - 饮料
 */
abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
