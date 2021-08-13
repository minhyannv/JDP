package jdp.decorator;

/**
 * @author wmy
 * @date 2021/8/11 10:46
 */

/**
 * 测试装饰器
 */
public class TestDecorator {
    public static void main(String[] args) {
        Beverage b1 = new Decaf();
        Beverage b2 = new Milk(b1);
        Beverage b3 = new Mocha(b2);
        Beverage b4 = new Soy(b3);
        Beverage b5 = new Soy(b4);
        System.out.println(b5.getDescription() + b5.cost());
    }
}
