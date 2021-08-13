package jdp.factory.abstract_factory;

/**
 * @author wmy
 * @date 2021/8/12 20:55
 */

/**
 * 具体饮料类：可乐
 */
public class Coke implements Drink {
    @Override
    public void drink() {
        System.out.println("Drinking Coke...");
    }
}
