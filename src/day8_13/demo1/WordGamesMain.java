package day8_13.demo1;

import java.util.Scanner;

public class WordGamesMain {
    public static void main(String[] args) {
        System.out.println("请输入两个角色:");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个角色的姓名和性别:");
        String name1=sc.next();
        char sex1=sc.next().charAt(0);
        System.out.println("请输入第二个角色的姓名和性别:");
        String name2=sc.next();
        char sex2=sc.next().charAt(0);
        WordGamesRole role=new WordGamesRole(name1,100,sex1);
        WordGamesRole role1=new WordGamesRole(name2,100,sex2);
        while (true)
        {
            role.stack(role1);//角色1攻击角色2
            if (role1.getBlood()==0)
            {
                System.out.println(role1.getName()+"被KO了");
                break;
            }
            role1.stack(role);
            if (role.getBlood()==0)
            {
                System.out.println(role.getName()+"被KO了");
                break;
            }
        }
    }
}
