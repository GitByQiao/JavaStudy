package day8_5.demo1;

import java.util.Scanner;

public class insertNumber {//一个从小到大数组插入一个数
    public static void main(String[] args) {
        int[] Num1={12,14,23,45,66,68,70,77,90,91};
        int[] Num2=new int[Num1.length+1];
        Scanner sc=new Scanner(System.in);
        int insert=sc.nextInt();
        int index = 0;
        for (int i = 0;i < Num1.length; i++) {
            if(Num1[i]<=insert)
            {
                index=i+1;
            }
        }
        for (int i = 0,j=0; i < Num2.length; i++) {
            if(i==index)
            {
                Num2[i]=insert;
            }
            else
            {
                Num2[i]=Num1[j];
                j++;
            }
        }
        for (int i = 0; i < Num2.length; i++) {
            System.out.print(Num2[i]+" ");
        }
    }
}