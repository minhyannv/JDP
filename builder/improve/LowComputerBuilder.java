package jdp.builder.improve;

/**
 * @author wmy
 * @date 2021/8/11 9:57
 */
//电脑建造者类：必须关联电脑产品
public class LowComputerBuilder {
    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 7500u");
        computer.setGpu("gtx940mx");
        computer.setMemory("4g");
        computer.setHd("1t机械");
        return computer;
    }
}
