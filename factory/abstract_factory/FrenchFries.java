package jdp.factory.abstract_factory;

/**
 * @author wmy
 * @date 2021/8/12 20:55
 */

/**
 * 具体食物类：炸薯条
 */
public class FrenchFries implements Food {
    @Override
    public void eat() {
        System.out.println("Eating FrenchFries...");
    }
}
