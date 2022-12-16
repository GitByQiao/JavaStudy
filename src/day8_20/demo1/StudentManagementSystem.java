package day8_20.demo1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public  void startStudentManagementSystem(){
        //输入选择的数字
        Scanner sc=new Scanner(System.in);
        ArrayList<StudentsInfo> studentArray=new ArrayList<>();//定义一个集合存储数据
        while (true) {
            System.out.println(
                    "------------欢迎来到黑马学生管理系统------------"+
                    "\t1：添加学生\t"+
                    "\t2：删除学生\t"+
                    "\t3：修改学生\t"+
                    "\t4：查询学生\t"+
                    "\t5：退出\t"+
                    "\t请输入您的选择:\t"
            );
            String choose=sc.next();
            switch (choose){
                case "1":{
                    insert(studentArray);break;//添加学生
                }
                case "2":{
                    delete(studentArray);break;//删除学生
                }
                case "3":{
                    update(studentArray);break;//修改学生
                }
                case "4":{
                    query(studentArray);break;//查询学生
                }
                case "5":{
                    System.exit(0);//退出
                }
                default:{
                    System.out.println("请输入正确的数字");
                }
            }
        }
    }
    public static void insert(ArrayList<StudentsInfo> studentArray){//增
        StudentsInfo students=new StudentsInfo();//定义一个学生对象
        Scanner sc = new Scanner(System.in);
        String sId = null;
        while (true) {
            System.out.println("请输入学生的学号:");
            sId = sc.next();
            if (constant(sId,studentArray)){//查看学号是否存在
                System.out.println("当前学号"+sId+"已存在,请重新输入");
            }else{
                students.setId(sId);
                break;
            }
        }
        System.out.println("请输入学生的姓名:");
        String sName = sc.next();
        students.setName(sName);
        System.out.println("请输入学生的年龄:");
        int sAge = sc.nextInt();
        students.setAge(sAge);
        System.out.println("请输入学生的地址:");
        String sAddress = sc.next();
        students.setAddress(sAddress);
        boolean isInsert=studentArray.add(students);//把学生对象的数据存入集合并返回判断是否插入成功
        if (isInsert){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败请重新插入");
        }
    }
    public static void delete(ArrayList<StudentsInfo> studentArray){//删
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要删除的学号");
        String sid=sc.next();
        int sid1 = isSid(sid, studentArray);//获得要删除学号的在集合的下标
        if (sid1>=0){//下标大于等于0进行删除
            studentArray.remove(sid1);
            System.out.println("删除成功");
        }else {//下标小于0删除失败
            System.out.println("要删除的id不存在，删除失败，请重新输入操作");
        }
    }
    public static void update(ArrayList<StudentsInfo> studentArray){//改
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要进行修改的学号");
        String sid= sc.next();//输入进行修改的学号
        int sid1 = isSid(sid, studentArray);//判断学号是否存在并返回当前学号的下标
        if (sid1==-1){
            System.out.println("学号不存在，修改失败，请重新输入");
        }else {
            System.out.println("请输入修改后的姓名");
            String name=sc.next();
            System.out.println("请输入修改后的年龄");
            int age=sc.nextInt();
            System.out.println("请输入修改后的地址");
            String address=sc.next();
            studentArray.get(sid1).setName(name);
            studentArray.get(sid1).setAge(age);
            studentArray.get(sid1).setAddress(address);
        }
    }
    public static void query(ArrayList<StudentsInfo> studentArray){//查
        if (studentArray.size()==0){
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        System.out.println("学号\t\t"+"\t\t姓名\t\t"+"\t\t年龄\t\t"+"\t\t地址");
        for (int i = 0; i < studentArray.size(); i++) {
            System.out.println(studentArray.get(i).getId()+"\t\t"+studentArray.get(i).getName()+"\t\t"+studentArray.get(i).getAge()+"\t\t"+studentArray.get(i).getAddress());
        }
    }
    public static boolean constant(String sid, ArrayList<StudentsInfo> studentArray){//比较学号是否出现过
        /*for (int i = 0; i < studentArray.size(); i++) {
            boolean equals = studentArray.get(i).getId().equals(sid);
            if (equals){
                return true;
            }
        }
        return false;*/
        return isSid(sid, studentArray)>=0;
    }
    public static int isSid(String sid, ArrayList<StudentsInfo> studentArray){
        //查看输入的学号是否存在，
        // 存在返回学号存在的下标，不存在返回-1
        for (int i = 0; i < studentArray.size(); i++) {
            if (studentArray.get(i).getId().equals(sid)){
                return i;
            }
        }
        return -1;
    }
}
