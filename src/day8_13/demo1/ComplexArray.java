package day8_13.demo1;

import java.util.Scanner;

public class ComplexArray {
    public static void main(String[] args) {
        /*定义数组存储n个学生对象。
	学生的属性：学号，姓名，年龄。
	要求1：添加的时候需要进行学号的唯一性判断。   //添加时满了就先建一个长度+1的把旧的放新的，不满时就添加进去
	要求2：添加完毕之后，遍历所有学生信息。
	要求3：通过id删除学生信息
           如果存在，则删除，如果不存在，则提示删除失败。    //删除可以把那个变为null，访问时只访问非null的数据
	要求4：删除完毕之后，遍历所有学生信息。
	要求5：id为2的学生，年龄+1岁*/
        //创建一个长度为n的数组对象
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要输入的学生信息个数:");
        int n=sc.nextInt();
        ComplexArrayStudent[] students=new ComplexArrayStudent[n];
        for (int i = 0; i < students.length;) {
            System.out.println("请依次输入第"+(i+1)+"个学生的学号 姓名 年龄");
            int id=sc.nextInt();
            String name=sc.next();
            int age=sc.nextInt();
            boolean is=IsOnly(students,id);//判断是否唯一
            if (is){
                ComplexArrayStudent student=new ComplexArrayStudent(id,name,age);//唯一的话添加数据
                students[i]=student;
            }
            else {
                System.out.println("当前学号已存在,请重新输入:");
                continue;
            }
            System.out.println("该学生的学号是:"+students[i].id+"该学生的姓名是:"+students[i].name+" "+"该学生的年龄是:"+students[i].age);
            i++;
        }
    }
    public static boolean IsOnly(ComplexArrayStudent[] students, int id){//学号唯一性进行判断
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null)//判断是否是空数组
            {
                if(students[i].id==id)
                {
                    return false;
                }
            }
        }
        return true;
    }
    /*public static void InsertArray(ComplexArrayStudent[] students,int id,String name,int age,boolean isOnly,int i){//根据学号是否唯一插入数据
        if (isOnly){
            ComplexArrayStudent student=new ComplexArrayStudent(id,name,age);
            students[i]=student;
        }else {
            System.out.println("当前学号已存在,请重新输入:");
        }
    }*/
}
