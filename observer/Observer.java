package jdp.observer;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 21:07
 */

/**
 * 抽象观察者
 */
public interface Observer {
    /**
     * 消息更新
     *
     * @param message
     */
    public void update(String message);

}
