package jdp.principle.single_responsibility;

/**
 * @author wmy
 * @date 2021/8/9 20:56
 */
//类上上满足单一职责

public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");
        SkyVehicle skyVehicle = new SkyVehicle();
        skyVehicle.run("飞机");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
    }
}

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行...");
    }
}

class SkyVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空运行...");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在水上运行...");
    }
}