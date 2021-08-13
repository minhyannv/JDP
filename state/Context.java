package jdp.state;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 23:07
 */

/**
 * 定义一个环境类来维护State接口
 */
public class Context {
    private State state;

    public Context() {
    }

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        System.out.println("订单信息已更新！");
        this.state = state;
        this.state.handle();
    }
}
