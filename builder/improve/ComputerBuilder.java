package jdp.builder.improve;

/**
 * @author wmy
 * @date 2021/8/11 10:09
 */
public interface ComputerBuilder {
    public abstract void setCpu();

    public abstract void setGpu();

    public abstract void setMemory();

    public abstract void setHd();

    Computer build();

}
