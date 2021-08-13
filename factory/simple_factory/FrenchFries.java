package jdp.factory.simple_factory;

/**
 * @author wmy
 * @date 2021/8/12 16:09
 */

/**
 * 具体产品:炸薯条
 */
class FrenchFries implements Food {
    @Override
    public void eat() {
        System.out.println("Eating FrenchFries...");
    }
}
