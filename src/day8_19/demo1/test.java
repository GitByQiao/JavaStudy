package day8_19.demo1;

public class test {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("123456789");
        sb.deleteCharAt(1);//删除指定下标的字符
        sb.delete(3,6);//删除从当前下标到结尾下标的字符
        int index = sb.indexOf("9");
        System.out.println(sb);
        System.out.println(index);
        System.out.println(sb.toString());
    }
}
