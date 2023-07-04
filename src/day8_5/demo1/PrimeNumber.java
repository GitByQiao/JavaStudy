package day8_5.demo1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        //给定一个范围判断有多少个质数
        //1.输入一个范围
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入范围下限");
        int from=sc.nextInt();
        System.out.println("请输入范围上限");
        int to=sc.nextInt();
        int sum = 0;
        for (int i=from;i<=to;i++)
        {
            sum += getCount(i);
            System.out.println("质数一共有"+sum+"个");
        }
        //2.判断一个数是否是质数
        // 3.质数累加

    }

    public static int getCount(int i) {
        boolean flag=true;
        int Number = i;
        int count=0;
        for(int j=2;j<Number;j++)
        {
            if (Number%j==0)
            {
                flag=false;
                System.out.println("数字"+Number+"不是一个质数");
                break;
            }
        }
        if(flag==true)
        {
            System.out.println("数字"+Number+"是一个质数");
            count++;
        }
        return count;
    }
}
