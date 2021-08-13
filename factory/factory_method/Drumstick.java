package jdp.factory.factory_method;

/**
 * @author wmy
 * @date 2021/8/12 20:34
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

