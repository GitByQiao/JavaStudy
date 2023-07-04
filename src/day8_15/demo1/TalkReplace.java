package day8_15.demo1;

public class TalkReplace {
    public static void main(String[] args) {
        String s="我谢谢你,nnd";
        String[] talk={"tmd","nnd","wtf"};
        for (int i = 0; i < talk.length; i++) {
            s=s.replace(talk[i],"***");//replace会生成一个新的字符串
        }
        System.out.println(s);
    }
}
