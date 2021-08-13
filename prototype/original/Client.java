package jdp.prototype.original;

/**
 * @author wmy
 * @date 2021/8/10 16:37
 */
public class Client {
    public static void main(String[] args) {
        //传统方法
        Sheep sheep1 = new Sheep("1", 1, "white");
        Sheep sheep2 = new Sheep("2", 2, "blue");
        Sheep sheep3 = new Sheep("3", 3, "red");
        Sheep sheep4 = new Sheep("4", 4, "greed");
        Sheep sheep5 = new Sheep("5", 5, "red");
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
    }
}
