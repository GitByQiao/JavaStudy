package day8_29.demo1;

import java.util.Random;

public class rCode {
    public static void main(String[] args) {
        char[] c=new char[52];
        char[] code=new char[5];
        int count=0;
        arr(c,count);
        System.out.println(randomCode(c,code));
    }
    public static void arr(char[] c,int count){
        for (int i = 0; i < 26; i++) {
            c[count++]= (char) (i+'A');
            c[count++]=(char) (i+'a');
        }
    }
    public static String randomCode(char[] c,char[] code){
        Random random=new Random();
        for (int i = 0; i < 4; i++) {
            int r= random.nextInt(c.length);
            code[i]=c[r];
        }
        int math= random.nextInt(10)+48;
        code[code.length-1]= (char) math;
        int index=random.nextInt(5);
        char temp=code[index];
        code[index]=code[code.length-1];
        code[code.length-1]=temp;
        return new String(code);
    }
}
