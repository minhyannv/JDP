package jdp.factory.abstract_factory;

/**
 * @author wmy
 * @date 2021/8/12 20:55
 */

/**
 * 测试抽象工厂
 */
class TestAbstractFactory {
    public static void main(String[] args) {
        Factory factory = new KFCFactory();
        factory.getFood().eat();
        factory.getDrink().drink();
        factory = new GoldenArchFactory();
        factory.getFood().eat();
        factory.getDrink().drink();

    }

}
