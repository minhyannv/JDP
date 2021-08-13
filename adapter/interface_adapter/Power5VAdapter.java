package jdp.adapter.interface_adapter;

/**
 * @author wmy
 * @date 2021/8/12 15:14
 */

/**
 * 抽象适配器子类：只重载需要的方法
 */
public class Power5VAdapter extends PowerAdapter {

    public Power5VAdapter(AC220 ac220) {
        super(ac220);
    }

    @Override
    public int output5V() {
        int output = 0;
        if (ac220 != null) {
            output = ac220.output220V() / 44;
        }
        return output;
    }
}
