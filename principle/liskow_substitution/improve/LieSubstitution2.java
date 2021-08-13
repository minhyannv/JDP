package jdp.principle.liskow_substitution.improve;

/**
 * @author wmy
 * @date 2021/8/10 9:03
 */
//里式替换原则
//对类进行提升，采用依赖，聚合或者组合的方法
public class LieSubstitution2 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.func1(11, 3));
        B b = new B();
        System.out.println(b.func2(11, 3));
    }

}

class Base {
}

class A {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends Base {
    //依赖
    private A a = new A();

    public int func2(int num1, int num2) {
        return num1 + num2;
    }

    public int func3(int num1, int num2) {
        return a.func1(num1, num2);
    }
}
