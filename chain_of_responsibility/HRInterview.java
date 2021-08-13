package jdp.chain_of_responsibility;

import java.util.Random;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 22:01
 */

/**
 * HR面试
 */
public class HRInterview extends Interview {

    public HRInterview(Interview interview) {
        super(interview);
    }

    @Override
    public String runInterview(String name) {
        //HR面试
        System.out.println(name + " 开始参加HR面试");
        System.out.println("HR先聊了聊公司的背景、现状、前景...");
        System.out.println(name + " 反映很满意。");
        System.out.println("HR开始谈工资。");
        int score = new Random().nextInt(10) + 20;
        if (score <= 25) {
            System.out.println(name + " 期望工资涨幅为" + score + "%，在HR承受范围内，通过了面试。");
        } else {
            System.out.println(name + " 期望工资涨幅为" + score + "%，超出HR承受范围内，未通过面试。");
            return "面试结果：未通过HR面试";
        }
        System.out.println(name + " 进入下一轮面试。");
        System.out.println("--------------------------------");
        return super.getInterview().runInterview(name);

    }
}
