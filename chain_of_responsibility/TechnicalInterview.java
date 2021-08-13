package jdp.chain_of_responsibility;

import java.util.Random;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 22:01
 */

/**
 * 技术面试
 */
public class TechnicalInterview extends Interview {
    public TechnicalInterview(Interview interview) {
        super(interview);
    }

    @Override
    public String runInterview(String name) {
        //技术面试
        System.out.println(name + " 开始参加技术面试");
        System.out.println("技术面试官先问了一些基础知识");
        boolean pass = new Random().nextBoolean();
        if (pass) {
            System.out.println(name + " 基础知识回答得很完美，继续技术面试。");
        } else {
            System.out.println(name + " 基础知识掌握的很差，未通过技术面试。");
            return "面试结果：未通过技术面试";
        }
        System.out.println("技术面试官又问了一些高级知识");
        pass = new Random().nextBoolean();
        if (pass) {
            System.out.println(name + " 高级知识回答得马马虎虎，继续技术面试。");
        } else {
            System.out.println(name + " 高级知识简直是不懂装通，未通过技术面试。");
            return "面试结果：未通过技术面试";
        }

        System.out.println(name + " 进入下一轮面试。");
        System.out.println("--------------------------------");
        return super.getInterview().runInterview(name);
    }
}
