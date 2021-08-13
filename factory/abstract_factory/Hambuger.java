package jdp.factory.abstract_factory;

/**
 * @author wmy
 * @date 2021/8/12 20:55
 */

/**
 * 具体食物类：汉堡包
 */
public class Hambuger implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Hambuger...");
    }
}
