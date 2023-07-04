package day8_15.demo1;

public class InterceptNumber {
    public static void main(String[] args) {
        String s="123456789";
        String substring = s.substring(0, 3);//截取字符串包头不包尾   [begin,end)
        String substring1 = s.substring(s.length() - 4, s.length() - 1);
        String result=substring+"*****"+substring1;
        System.out.println(result);
    }
}
