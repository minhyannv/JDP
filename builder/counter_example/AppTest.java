package jdp.builder.counter_example;

/**
 * @author wmy
 * @date 2021/8/11 9:51
 */
//违反迪米特法则
public class AppTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setCpu("i7 7500u");
        computer.setGpu("gt940mx");
        computer.setMemory("16g");
        computer.setHd("1t机械");
        System.out.println(computer);

    }
}
