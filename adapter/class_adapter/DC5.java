package jdp.adapter.class_adapter;

/**
 * @author wmy
 * @date 2021/8/12 14:54
 */
//

/**
 * 目标角色(Target)：这就是所期待得到的接口。
 * 注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 */
public interface DC5 {
    /**
     * 输出5V直流电（期待得到的接口）
     *
     * @return
     */
    int output5V();
}
