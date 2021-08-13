package jdp.adapter.object_adapter;

/**
 * @author wmy
 * @date 2021/8/12 14:55
 */

/**
 * 对象适配器
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    /**
     * 输出5V直流电
     *
     * @return
     */
    @Override
    public int output5V() {
        int output = this.ac220.output220V();
        return (output / 44);
    }
}
