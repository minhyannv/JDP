package jdp.adapter.interface_adapter;

/**
 * @author wmy
 * @date 2021/8/12 15:24
 */

/**
 * 测试接口适配器
 */
public class TestInterfaceAdapter {
    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        Power5VAdapter power5VAdapter = new Power5VAdapter(ac220);
        System.out.println("输出电流：" + power5VAdapter.output5V() + "V");

    }
}
