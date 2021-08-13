package jdp.builder.improve;

/**
 * @author wmy
 * @date 2021/8/11 9:57
 */
//电脑建造者类：必须关联电脑产品
public class AdvancedComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i9 7500hd");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gt940mx");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16g");
    }

    @Override
    public void setHd() {
        computer.setHd("2t机械");
    }

    public Computer build() {
        return computer;
    }
}
