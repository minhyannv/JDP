package jdp.principle.open_closed_principle;

/**
 * @author wmy
 * @date 2021/8/10 9:19
 */
//开闭原则
// 对扩展（提供者）开放，对修改（使用方）关闭
//该例违反了开闭原则,若新增一个绘制三角形，则需改动使用方代码和提供者代码
public class OpenClosedPrinciple1 {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
    }

    public void drawRectangle(Shape r) {
        System.out.println(" 绘制矩形");
    }

    public void drawCircle(Shape r) {
        System.out.println(" 绘制圆形");
    }
}

class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}
