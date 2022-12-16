package day8_20.demo1;

import java.util.ArrayList;
import java.util.Random;

public class codeTest {
    public static void main(String[] args) {
            ArrayList<Character> arrayList=new ArrayList<>();//定义一个集合存储a-z和A-Z字符
            StringBuilder sb=new StringBuilder();int r;//定义一个stringBuilder对象进行字符拼接
            Random random=new Random();
            for (int i = 0; i < 26; i++) {
                arrayList.add((char) ('a'+i));//把a-z和A-Z存到集合中
                arrayList.add((char) ('A'+i));
            }
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.print(arrayList.get(i));
//        }
        for (int i = 0; i < 4; i++) {
            r=random.nextInt(arrayList.size());//生成一个集合范围是随机数
            sb.append(arrayList.get(r));//把随机的字符拼接到stringBuilder容器中
        }
        r=random.nextInt(10);
        sb.append(r);
        char[] chars = sb.toString().toCharArray();//变成字符数组进行交换
        int s=random.nextInt(chars.length);
        char temp=chars[s];
        chars[s]=chars[chars.length-1];
        chars[chars.length-1]=temp;
        System.out.println(new String(chars));
        System.out.println(chars.toString());
        /*int s=random.nextInt(5);
        char c = sb.charAt(s);     运用stringBuilder的方法replace进行交换
        sb.replace(s,s+1, String.valueOf(sb.charAt(sb.length()-1)));
        sb.replace(sb.length()-1,sb.length(), String.valueOf(c));
        System.out.println(sb);*/

    }
}
