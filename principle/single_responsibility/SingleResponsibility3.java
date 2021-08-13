package jdp.principle.single_responsibility;

/**
 * @author wmy
 * @date 2021/8/9 20:56
 */
//方法上满足单一职责
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.runRoad("汽车");
        vehicle2.runSky("飞机");
        vehicle2.runWater("轮船");

    }
}

class Vehicle2 {
    public void runRoad(String vehicle) {
        System.out.println(vehicle + "在公路上运行...");
    }

    public void runSky(String vehicle) {
        System.out.println(vehicle + "在天空运行...");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水上运行...");
    }

}
