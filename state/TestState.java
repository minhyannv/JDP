package jdp.state;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 23:11
 */

/**
 * 测试状态模式
 */
public class TestState {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new Booked());
        context.setState(new Payed());
        context.setState(new Sended());
        context.setState(new InWay());
        context.setState(new Recieved());
    }
}
