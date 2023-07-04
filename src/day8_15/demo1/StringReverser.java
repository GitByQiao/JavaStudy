package day8_15.demo1;

import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        /*定义一个方法，实现字符串反转。
        键盘录入一个字符串，调用该方法后，在控制台输出结果例如，键盘录入abc，输出结果cba*/
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();//输入换行符结束输入
        String reverse = reverse(s);
        System.out.println(reverse);
    }
    public static String reverse(String str){
        String result="";//空白字符串接受数据
        for (int i = 0; i < str.length(); i++) {
            result+=str.charAt(str.length()-i-1);
        }
        return result;
    }
}
