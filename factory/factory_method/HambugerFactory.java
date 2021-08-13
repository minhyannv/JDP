package jdp.factory.factory_method;

/**
 * @author wmy
 * @date 2021/8/12 20:36
 */

/**
 * 生产汉堡包的工厂
 */
public class HambugerFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new Hambuger();
    }
}
