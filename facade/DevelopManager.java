package jdp.facade;

/**
 * @author wmy
 * @date 2021/8/12 11:15
 */

/**
 * 开发经理
 */
public class DevelopManager extends AbstractWorker {
    public DevelopManager(String name) {
        super(name, "开发经理");
    }

    public void makeDevelopmentPlan() {
        System.out.println(super.getName() + " | " + super.getJob() + " 制定了研发计划...");
    }

}
