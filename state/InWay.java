package jdp.state;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 23:08
 */

/**
 * 具体状态角色(ConcreteState):订单运送状态
 */
public class InWay implements State {
    @Override
    public void handle() {
        System.out.println("订单正在运送中！");
    }
}
