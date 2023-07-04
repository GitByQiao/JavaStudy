package day8_5.demo1;

import java.util.Random;

public class RandomCode {//生成4位的验证码
    public static void main(String[] args) {//方法一
        int[] Num =new int[52];
        Random random=new Random();
        int rN=random.nextInt(10);
        for (int i=0,j=97;i<26;i++,j++)
        {
            Num[i]=j;
        }
        for (int i=26,j=65;i<52;i++,j++)
        {
            Num[i]=j;
        }
        for (int i = 0; i < 3; i++) {
            int rL=random.nextInt(52);
            System.out.print((char) Num[rL]);
        }
        System.out.print(rN);
    }
    //方法二
    /*public static void main(String[] args) {
        *//*char[] letter={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};//英语字母
        int[] number={0,1,2,3,4,5,6,7,8,9};*//*
        char[] letter=new char[52];
        for (int i=0;i< letter.length;i++)
        {
            if(i<=25)
            {
                letter[i]=(char)(97+i);
            }
            else
            {
                letter[i]=(char)(65+i-26);
            }
        }
        Random rLetter=new Random();//52字母随机一个字母;
        Random rNumber=new Random();//10个数字随机一个数字;
        int rN=rNumber.nextInt(10);
        for (int i=0;i<3;i++)
        {
            int rL=rLetter.nextInt(52);
            System.out.print(letter[rL]+" ");
        }
        System.out.print(rN);
    }*/
}
