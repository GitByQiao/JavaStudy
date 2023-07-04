package day8_5.demo1;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    //随机生成一个数然后输入数字判断大小猜数字
    public static void main(String[] args) {
        //注释
        Scanner sc=new Scanner(System.in);
        Random num=new Random();
        int randomNum=num.nextInt(100)+1;
        while (true)
        {
            System.out.println("请输入你要猜的数字");
            int guessNum=sc.nextInt();
            if(guessNum>randomNum)
            {
                System.out.println("大了");
            }
            else if (guessNum<randomNum)
            {
                System.out.println("小了");
            }
            else
            {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
