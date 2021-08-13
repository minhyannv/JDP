package jdp.factory.factory_method;

/**
 * @author wmy
 * @date 2021/8/12 20:36
 */

/**
 * 生产鸡腿的工厂
 */
public class DrumstickFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new Drumstick();
    }
}

