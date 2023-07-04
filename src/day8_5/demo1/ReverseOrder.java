package day8_5.demo1;

import java.util.Random;
import java.util.Scanner;

public class ReverseOrder {//数组随机交换
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int n=sc.nextInt();//输入n个整数
        int[] num1=new int[n];//定义n个数的数组
        int temp,randomNum;
        for (int i=0;i<=n-1;i++)
        {
            num1[i]=sc.nextInt();//输入n长度数组的数
//            System.out.println(num1);
        }
        for (int i = 0; i < num1.length; i++) {//生成n个随机数然后从1开始交换值
            randomNum=r.nextInt(num1.length);//生成一个随机数
            temp=num1[randomNum];//生成的随机数为下标和从1开始下标的数交换
            num1[randomNum]=num1[i];
            num1[i]=temp;
        }
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i]+" ");
        }
    }
}
