package day8_16.demo1;

import java.util.Scanner;

public class ExchangeRomanNumber1 {
    public static void main(String[] args) {
        /*键盘录入一个字符串，
        要求1∶长度为小于等于9
        要求2:只能是数字将内容变成罗马数字
        下面是阿拉伯数字跟罗马数字的对比关系:
        l- 1、l -2、- 3、IV - 4、V - 5、VlI - 6、VII- 7、V- 8、IX - 9注意点:
        罗马数字里面是没有0的
        如果键盘录入的数字包含0，可以变成””(长度为0的字符串)*/
        Scanner sc=new Scanner(System.in);
        String str;
        boolean is;
        while (true) {
            str=sc.nextLine();//输入一个字符串
            is=isRight(str);//返回判断结果
            if (is){
                System.out.println(ExChange(str));//输出转换的字符串
                break;
            }else {
                System.out.println("请输入长度小于等于9且都是数字的字符串:");
            }
        }
    }
    public static boolean isRight(String str){//判断字符串
        if (str.length()>9){//长度为小于等于9
            return false;
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)<'0'||str.charAt(i)>'9'){//只能是数字
                    return false;
                }
            }
            return true;
        }
    }
    public static String ExChange(String str){
        String[] s={"","Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ","Ⅵ","Ⅶ","Ⅷ","Ⅸ"};//查表法，通过数字下标一一对应进行转换
        StringBuilder sb=new StringBuilder();//放容器里拼接节省内存
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);//获得字符
            int num=c-'0';//获得数字
            sb.append(s[num]);//拼接
        }
        return sb.toString();//变成字符串返回
    }
}
