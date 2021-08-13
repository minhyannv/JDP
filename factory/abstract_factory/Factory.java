package jdp.factory.abstract_factory;

/**
 * @author wmy
 * @date 2021/8/12 20:55
 */

/**
 * 抽象工厂
 */
public interface Factory {

    Food getFood();

    Drink getDrink();
}
