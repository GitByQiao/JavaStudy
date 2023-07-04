package day8_5.demo1;

import java.util.Scanner;

public class EnDeNumber {//对数字进行加解密    加密：1.+5,   2.取余   3.数组反转    4.生成一个数      解密：还原原数
    public static void main(String[] args) {
        //对一个数字进行加解密
        //加密：+5;取余;反转;
        //加密;
        Scanner sc=new Scanner(System.in);
        int Number1=sc.nextInt();
        int count = 0;int Number2=Number1;int sum=0;int sumArr4=0;
        while (Number1!=0)
        {
            Number1=Number1/10;
            count++;//计算几位数
        }
        int[] arr1=new int[count];
        int[] arr3=new int[count];
        int[] arr2=Encryption(count,arr1,Number2,sum);//加密后
        int[] arr4=Decryption(arr2,arr3);//解密后
        //System.out.println("\n");
        for (int i = 0; i < arr4.length; i++) {
            sumArr4=sumArr4*10+arr4[i];//数字求和
        }
        System.out.println("\n"+sumArr4);
    }
    public static int[] Encryption(int count,int[] arr1,int Number2,int sum)//求加密
    {
        for (int i = 0; i < count; i++) {
            arr1[i]=Number2%10;//反转
            Number2=Number2/10;//+5
            arr1[i]+=5;
        }
        for (int i = 0; i < arr1.length; i++) {//取余
            arr1[i]=arr1[i]%10;
            sum=sum*10+arr1[i];
            System.out.print("取余为:"+arr1[i]+"     "+sum+"\n");
        }
        //System.out.println("\n"+"数字位数为:"+count);
        return arr1;
    }
    public static int[] Decryption(int[] arr2,int[] arr3)//解密
    {
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);//打印加密后
            if(arr2[i]<=4)
            {
                arr3[i]=arr2[i]+10;//取余的反转赋值给新数组
            }
            else
            {
                arr3[i]=arr2[i];
            }
            arr3[i]=arr3[i]-5;//-5得到原数组
        }
        for (int i = 0,j=arr3.length-1; i < j; i++,j--) {
            int temp;
            temp=arr3[j];
            arr3[j]=arr3[i];
            arr3[i]=temp;
        }
        return arr3;
    }
}
