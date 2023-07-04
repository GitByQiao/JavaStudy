package day8_15.demo1;

public class BuilderString {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();//无参数定义
        StringBuilder sb2=new StringBuilder("sb2");//有参数定义
        sb2.append("小牛马");//添加数据到容器
        sb2.reverse();//反转容器内数据
        int num=sb2.length();
        String string1 = sb2.toString();//转变为string类型
        System.out.println(string1);
        System.out.println(num);
    }
}
