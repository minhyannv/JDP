package jdp.chain_of_responsibility;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 21:55
 */

/**
 * 抽象面试类
 */
public abstract class Interview {

    /**
     * 下一轮面试（可类比链表的下一个节点）
     */
    private Interview interview;

    public Interview(Interview interview) {
        this.interview = interview;
    }

    public Interview getInterview() {
        return interview;
    }

    /**
     * 进行面试
     */
    public abstract String runInterview(String name);
}
