package jdp.observer;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 21:37
 */

/**
 * 测试观察者模式
 */
public class TestObserver {
    public static void main(String[] args) {
        //Lily,Jack订阅报纸
        Newspaper newspaper = new Newspaper();
        User lily = new User(1, "Lily");
        User jack = new User(2, "Jack");
        newspaper.register(lily);
        newspaper.register(jack);

        //邮寄报纸
        newspaper.setMessage("中国青年报");
        newspaper.notifyObservers();
        System.out.println("--------------------------------------");

        //jack取消了订阅报纸
        newspaper.remove(jack);
        //邮寄报纸
        newspaper.setMessage("环球时报");
        newspaper.notifyObservers();
    }
}
