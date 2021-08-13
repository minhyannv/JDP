package jdp.observer;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 21:16
 */

/**
 * 主题抽象
 */
public interface Subject {
    /**
     * 注册
     */
    void register(Observer observer);

    /**
     * 取消注册
     */
    void remove(Observer observer);

    /**
     * 通知观察者们
     */
    void notifyObservers();

}
