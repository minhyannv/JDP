package jdp.factory.simple_factory;

/**
 * @author wmy
 * @date 2021/8/10 15:29
 */

//简单工厂
//优点：此时客户端不依赖于具体的产品类名，只依赖于接口FoodFactory,
//缺点：1.客户必须知道什么数字对应什么产品,
// 2.产品较多，必须会有大量case,工厂类变的臃肿
// 3.当客户端要扩展一个具体产品时，势必要的违反开闭原则（OCP）

/**
 * 测试简单工厂
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        Food f = FoodFactory.getFood(2);
        f.eat();
        f = FoodFactory.getFood(1);
        f.eat();
    }
}

