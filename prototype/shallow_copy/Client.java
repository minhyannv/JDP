package jdp.prototype.shallow_copy;

/**
 * @author wmy
 * @date 2021/8/10 16:37
 */
//浅拷贝：对于引用类型的成员变量，只拷贝引用地址
public class Client {
    public static void main(String[] args) {
        Sheep sheep1 = new Sheep("1", 1, "white");
        Sheep friend = new Sheep("friend", 2, "black");
        sheep1.friend = friend;
        Sheep sheep2 = sheep1.clone();
        Sheep sheep3 = sheep1.clone();
        Sheep sheep4 = sheep1.clone();
        Sheep sheep5 = sheep1.clone();
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep1 == sheep2);
        System.out.println(sheep1.friend == sheep2.friend);
        System.out.println(sheep3);
        System.out.println(sheep1 == sheep3);
        System.out.println(sheep1.friend == sheep3.friend);
        System.out.println(sheep4);
        System.out.println(sheep1 == sheep4);
        System.out.println(sheep1.friend == sheep4.friend);
        System.out.println(sheep5);
        System.out.println(sheep1 == sheep5);
        System.out.println(sheep1.friend == sheep5.friend);


    }
}
