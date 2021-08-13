package jdp.factory.factory_method;

/**
 * @author wmy
 * @date 2021/8/12 20:35
 */

/**
 * 生产薯条的工厂
 */
public class FrenchFriesFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new FrenchFries();
    }
}
