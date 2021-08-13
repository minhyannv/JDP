package jdp.adapter.class_adapter;

/**
 * @author wmy
 * @date 2021/8/12 14:57
 */

/**
 * 测试类适配器
 */
public class TestClassAdapter {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter();
        System.out.println("输出电流：" + dc5.output5V() + "V");
    }
}
