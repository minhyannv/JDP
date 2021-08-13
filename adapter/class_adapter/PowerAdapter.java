package jdp.adapter.class_adapter;

/**
 * @author wmy
 * @date 2021/8/12 14:55
 */

/**
 * 类适配器
 * 适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 */
public class PowerAdapter extends AC220 implements DC5 {
    /**
     * 输出5V直流电
     *
     * @return
     */
    @Override
    public int output5V() {
        int output = output220V();
        return (output / 44);
    }
}
