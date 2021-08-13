package jdp.factory.factory_method;

/**
 * @author wmy
 * @date 2021/8/12 16:09
 */

/**
 * 具体产品:汉堡包
 */
public class Hambuger implements Food {
    @Override
    public void eat() {
        System.out.println("Eating Hambuger...");
    }
}
