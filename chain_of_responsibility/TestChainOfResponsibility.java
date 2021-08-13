package jdp.chain_of_responsibility;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 22:25
 */

/**
 * 测试责任链模式
 */
public class TestChainOfResponsibility {

    public static void main(String[] args) {
        //1.普通求职者王五的面试过程
        String name1 = "王五";
        new ExamInterview(new TechnicalInterview(new HRInterview(new PassInterview()))).runInterview(name1);
        System.out.println();

        //1.高级求职者张三的面试过程
        String name2 = "张三";
        new TechnicalInterview(new HRInterview(new PassInterview())).runInterview(name2);

    }
}
