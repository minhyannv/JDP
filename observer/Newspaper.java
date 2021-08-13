package jdp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 21:17
 */

/**
 * 主题实现
 */
public class Newspaper implements Subject {
    /**
     * 订阅者列表
     */
    private List<Observer> observerList;

    /**
     * 报纸信息
     */
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public Newspaper() {
        this.observerList = new ArrayList<>();
    }

    /**
     * 订阅
     *
     * @param observer
     */
    @Override
    public void register(Observer observer) {
        this.observerList.add(observer);

    }

    /**
     * 取消订阅
     *
     * @param observer
     */
    @Override
    public void remove(Observer observer) {
        this.observerList.remove(observer);
    }


    /**
     * 向所有订阅者邮寄报纸
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }

}
