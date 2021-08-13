package jdp.builder.improve;

/**
 * @author wmy
 * @date 2021/8/11 9:51
 */
//针对不同需求，创建不同的建造者创建不同的产品
public class AppTest {
    public static void main(String[] args) {
        //高配建造者
        ComputerBuilder computerBuilder = new AdvancedComputerBuilder();
        Director director = new Director();
        Computer computer = director.build(computerBuilder);
        System.out.println(computer);

    }
}
