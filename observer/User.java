package jdp.observer;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 21:12
 */

/**
 * 具体观察者：订阅报纸的用户
 */
public class User implements Observer {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 接收报纸
     *
     * @param message
     */
    @Override
    public void update(String message) {
        System.out.println(this.name + " 接收报纸信息: " + message);
    }
}
