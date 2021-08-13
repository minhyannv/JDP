package jdp.factory.abstract_factory;

/**
 * @author wmy
 * @date 2021/8/12 20:55
 */

/**
 * 具体饮料类：咖啡
 */
public class Coffee implements Drink {
    @Override
    public void drink() {
        System.out.println("Drinking Coffee...");
    }
}
