package jdp.principle.single_responsibility;

/**
 * @author wmy
 * @date 2021/8/9 20:56
 */
//单一职责原则：降低类或方法的可读性，一个类或方法只负责一项职责
//不满足单一职责
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("火车");
        vehicle.run("轮船");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行...");
    }
}