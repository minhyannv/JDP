package jdp.principle.dependency_inversion;

/**
 * @author wmy
 * @date 2021/8/9 22:15
 */
//非依赖倒置方法
public class DependencyInversion1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

//接口
interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息：hello world!";
    }
}

//如果获取的对象是微信，QQ等，则Person也要添加对应的接收方法，不符合依赖倒置原则
class Person {
    public void receive(IReceiver iReceiver) {
        System.out.println(iReceiver.getInfo());
    }
}
