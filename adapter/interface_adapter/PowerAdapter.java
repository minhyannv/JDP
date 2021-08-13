package jdp.adapter.interface_adapter;

/**
 * @author wmy
 * @date 2021/8/12 15:21
 */

/**
 * 抽象适配器：接口所有方法空实现
 */
public abstract class PowerAdapter implements DC {
    protected AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        return 0;
    }

    @Override
    public int output9V() {
        return 0;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }
}
