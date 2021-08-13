package jdp.factory.simple_factory;

/**
 * @author wmy
 * @date 2021/8/12 16:09
 */

/**
 * 具体产品:鸡腿
 */
class Drumstick implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Drumstick...");
    }
}
