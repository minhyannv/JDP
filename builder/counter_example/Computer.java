package jdp.builder.counter_example;

/**
 * @author wmy
 * @date 2021/8/11 9:50
 */
public class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;


    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getHd() {
        return hd;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }
}
