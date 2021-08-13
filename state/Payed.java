package jdp.state;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 23:08
 */

/**
 * 具体状态角色(ConcreteState):支付状态
 */
public class Payed implements State {
    @Override
    public void handle() {
        System.out.println("您已支付订单！");
    }
}
