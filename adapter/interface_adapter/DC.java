package jdp.adapter.interface_adapter;

/**
 * @author wmy
 * @date 2021/8/12 15:12
 */

/**
 * 目标角色接口（提供多个接口）
 */
public interface DC {
    int output5V();

    int output9V();

    int output12V();

    int output24V();
}
