package jdp.factory.factory_method;

/**
 * @author wmy
 * @date 2021/8/12 20:38
 */

/**
 * 测试工厂方法模式
 */
public class TestFactoryMethod {
    public static void main(String[] args) {
        FoodFactory foodFactory = new HambugerFactory();
        foodFactory.getFood().eat();
        foodFactory = new DrumstickFactory();
        foodFactory.getFood().eat();
    }
}