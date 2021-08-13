package jdp.facade;

/**
 * @author wmy
 * @date 2021/8/12 11:15
 */

/**
 * 运维工程师
 */
public class Operations extends AbstractWorker {
    public Operations(String name) {
        super(name, "运维攻城狮");
    }

    public void operationAndMaintenance() {
        System.out.println(super.getName() + " | " + super.getJob() + " 持续进行运维...");
    }

}
