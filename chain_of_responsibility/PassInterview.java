package jdp.chain_of_responsibility;

/**
 * @author: wmy
 * @email: himywei@163.com
 * @date: 2021/8/11 22:23
 */

/**
 * 责任节点，通过面试
 */
public class PassInterview extends Interview {
    public PassInterview() {
        super(null);
    }

    @Override
    public String runInterview(String name) {
        System.out.println(name + " 通过了所有面试，恭喜你！");
        return "通过了所有面试，恭喜你！";
    }
}
