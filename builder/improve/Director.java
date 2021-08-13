package jdp.builder.improve;

/**
 * @author wmy
 * @date 2021/8/11 10:17
 */
//指挥者

public class Director {
    public Computer build(ComputerBuilder computerBuilder) {
        computerBuilder.setCpu();
        computerBuilder.setGpu();
        computerBuilder.setMemory();
        computerBuilder.setHd();
        return computerBuilder.build();
    }
}
