package jdp.principle.open_closed_principle.improve;

/**
 * @author wmy
 * @date 2021/8/10 9:19
 */
//开闭原则
// 对扩展（提供者）开放，对修改（使用方）关闭
//该例违反了开闭原则,若新增一个绘制三角形，则需改动使用方代码和提供者代码
// 改进之后，无需修改使用方的代码，只需对提供者的代码进行扩展即可
public class OpenClosedPrinciple2 {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }
}

abstract class Shape {
    int m_type;

    //抽象方法
    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制矩形");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制圆形");

    }
}
