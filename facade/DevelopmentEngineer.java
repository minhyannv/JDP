package jdp.facade;

/**
 * @author wmy
 * @date 2021/8/12 11:15
 */

/**
 * 研发工程师
 */
public class DevelopmentEngineer extends AbstractWorker {
    public DevelopmentEngineer(String name, String job) {
        super(name, job);
    }

    public void develop() {
        System.out.println(super.getName() + " | " + super.getJob() + " 开始进行研发...");
    }

}
