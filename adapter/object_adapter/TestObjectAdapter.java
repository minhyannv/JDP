package jdp.adapter.object_adapter;

/**
 * @author wmy
 * @date 2021/8/12 14:57
 */

/**
 * 测试对象适配器
 */
public class TestObjectAdapter {
    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        PowerAdapter powerAdapter = new PowerAdapter(ac220);
        System.out.println("输出电流：" + powerAdapter.output5V() + "V");

    }
}
