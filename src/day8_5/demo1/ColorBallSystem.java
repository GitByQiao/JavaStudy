package day8_5.demo1;

import java.util.Random;
import java.util.Scanner;

public class ColorBallSystem {//双色彩球抽奖系统
    public static void main(String[] args) {
        //系统抽取双色球
        int[] system=BallSystem();//记录系统抽取的双色球
//        System.out.println("\n"+"系统大奖双色球:");
//        for (int i = 0; i < system.length; i++) {
//            System.out.print(system[i]+" ");
//        }
        //自己抽取双色球
        int[] my=myBall();//记录自己抽奖的双色球号码
        System.out.println("自己双色球抽奖数字:");
        for (int i = 0; i < my.length; i++) {
            System.out.print(my[i]+" ");
        }
        System.out.println("\n"+"系统大奖双色球:");
        for (int i = 0; i < system.length; i++) {
            System.out.print(system[i]+" ");
        }
        //比较判断是否中奖
        int red=compareBall(my,system)[0];//红球中奖数量，篮球中奖数量
        int blue=compareBall(my,system)[1];
        System.out.println();
        System.out.println("红色中奖数:"+compareBall(my,system)[0]+"蓝色中奖数:"+compareBall(my,system)[1]);
        money(red,blue);
    }
    public static void money(int red,int blue)
    {
        if((blue==0&&red==1))
        {
            System.out.println("恭喜中奖0.8元");
        }
        else if((blue==0&&red==2)||(blue==1&&red==0))
        {
            System.out.println("恭喜中奖2元");
        }
        else if((blue==0&&red==3)||(blue==1&&red==1))
        {
            System.out.println("恭喜中奖3元");
        }
        else if((blue==0&&red==4)||(blue==1&&red==2))
        {
            System.out.println("恭喜中奖5元");
        }
        else if((blue==0&&red==5)||(blue==1&&red==3))
        {
            System.out.println("恭喜中奖10元");
        }
        else if((blue==0&&red==6)||(blue==1&&red==4))
        {
            System.out.println("恭喜中奖20元");
        }
        else if ((blue==1&&red==5))
        {
            System.out.println("恭喜中奖50元");
        }
        else if((blue==1&&red==6))
        {
            System.out.println("恭喜中奖100元");
        }
        else
        {
            System.out.println("安慰奖0.2元");
        }
    }
    public static int[] compareBall(int[] my,int[] system)
    {
        int[] redBlueNumber=new int[2];//定义数组装红蓝匹配数
        int red=0,blue=0;
        for (int i = 0; i < my.length-1; i++) {
            if(my[i]==system[i])
            {
                red++;//红色匹配数
            }
        }
        if(my[my.length-1]==system[system.length-1])
        {
            blue++;//蓝色匹配数
        }
        redBlueNumber[0]=red;
        redBlueNumber[1]=blue;
        return redBlueNumber;
    }
    public static int[] BallSystem()//系统抽取7个球
    {
        Random random=new Random();
        int[] BallSystem=new int[7];
        for (int i = 0; i < BallSystem.length-1;) {
            int r=random.nextInt(36)+1;//随机的红球号码
            boolean isExistence=isExistence(BallSystem,r);//存在的判断结果
            if(!isExistence)//不存在收入数组,存在继续判断当前下标
            {
                BallSystem[i]=r;
                i++;
            }
        }
        int b=random.nextInt(16)+1;//随机篮球
        BallSystem[BallSystem.length-1]=b;
        return BallSystem;
    }
    public static int[] myBall()//我选取的号码
    {
        Scanner sc=new Scanner(System.in);
        System.out.println();
        int[] myBall=new int[7];//记录我的抽奖号码
        for (int i = 0; i < myBall.length-1;) {//我的红球号码
            System.out.print("输入的第"+(i+1)+"个红球");
            int inputNumber=sc.nextInt();//输入选取的红色号码
            if(inputNumber>=1&&inputNumber<=36)//判断红色号码是否合法
            {
                if (!isExistence(myBall,inputNumber))//判断红色号码是否存在，不存在时存入,存在时当前位置接着循环
                {
                    myBall[i]=inputNumber;
                    i++;
                }
                else
                {
                    System.out.println("已存在当前红球号码,请输入不同的红球号码");
                }
            }
            else
            {
                System.out.println("号码范围1-36,输入的号码超出范围,请重新输入:");//密码不合规范时做出提醒
            }
        }
        while (true)//一直循环知道输入的篮球合法后跳出
        {
            System.out.print("\n"+"输入的第"+1+"个篮球");
            int blueNumber=sc.nextInt();//输入篮球
            if(blueNumber>=1&&blueNumber<=16)
            {
                myBall[myBall.length-1]=blueNumber;//篮球输入到最后一个，记录后跳出
                break;
            }
            else
            {
                System.out.println("号码范围1-16,,输入的号码超出范围,请重新输入:");//篮球号码不合法提示
            }
        }
        return myBall;
    }
    public static boolean isExistence(int[] BallSystem,int r)//判断随机的数在数组是否存在
    {
        for (int i = 0; i < BallSystem.length-1;) {
            if(r==BallSystem[i])
            {
                return true;
            }
            else
            {
                i++;
            }
        }
        return false;
    }
}
