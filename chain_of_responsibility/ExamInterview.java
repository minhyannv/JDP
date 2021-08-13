package jdp.chain_of_responsibility;

import java.util.Random;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 22:01
 */

/**
 * 笔试
 */
public class ExamInterview extends Interview {

    public ExamInterview(Interview interview) {
        super(interview);
    }

    @Override
    public String runInterview(String name) {
        System.out.println(name + "开始参加笔试");
        System.out.println("此轮笔试共计10道选择题，5道机试题，共计100分，答题时间60分钟。");
        int score = new Random().nextInt(50) + 50;
        if (score >= 60) {
            System.out.println(name + " 笔试得分为 " + score + " 通过了笔试。");
        } else {
            System.out.println(name + " 笔试得分为 " + score + ", 未通过笔试。");
            return "面试结果：未通过笔试";
        }
        System.out.println(name + " 进入下一轮面试。");
        System.out.println("--------------------------------");
        return super.getInterview().runInterview(name);
    }
}
