package jdp.principle.demeter_principle.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmy
 * @date 2021/8/10 9:43
 */
//迪米特法则：对自己依赖的类知道的越少越好
//依赖的类（直接朋友）：成员变量，方法参数，方法返回值
public class DemeterPrinciple2 {

    public static void main(String[] args) {
        // SchoolManager
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }

}

//学校总部员工类
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


//学院员工类
class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


//管理学院员工类
class CollegeManager {
    //返回所有学院的员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    public void printEmployee() {
        List<CollegeEmployee> list1 = this.getAllEmployee();
        System.out.println("------------学院员工id------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

//学校管理类
//分析SchoolManager的直接朋友有哪些
//Employee,CollegeManager
//CollegeEmployee不是直接朋友，是以局部变量的形式出现在SchoolManager中，违反了开闭原则
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校员工id= " + i);
            list.add(emp);
        }
        return list;
    }


    //输出学校总部和学院员工id
    void printAllEmployee(CollegeManager sub) {
        //1.将输出学院员工的方法分装到CollegeManager中
        sub.printEmployee();

        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校员工id------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}


