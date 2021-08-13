package jdp.principle.liskow_substitution;

/**
 * @author wmy
 * @date 2021/8/10 9:03
 */
//不满足里式替换原则
// 类B无意重写了类A的方法，导致方法功能出现错误
public class LieSubstitution1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.func(11, 3));
        B b = new B();
        System.out.println(a.func(11, 3));
    }

}

class A {
    public int func(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends A {
    public int func1(int num1, int num2) {
        return num1 + num2;
    }
}
