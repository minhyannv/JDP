package jdp.factory.abstract_factory;

/**
 * @author wmy
 * @date 2021/8/12 20:55
 */

/**
 * 具体工厂:金拱门
 */
public class GoldenArchFactory implements Factory {

    @Override
    public Food getFood() {
        System.out.println("金拱门店制作...");
        return new Hambuger();
    }

    @Override
    public Drink getDrink() {
        System.out.println("金拱门店制作...");
        return new Coffee();
    }
}
