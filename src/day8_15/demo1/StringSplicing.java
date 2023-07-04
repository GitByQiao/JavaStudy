package day8_15.demo1;

public class StringSplicing {
    public static void main(String[] args) {
        /*定义一个方法，把 int数组中的数据按照指定的格式拼接成一个字符串返回,调用该方法，并在控制台输出结果。
        例如:数组为int[]arr = {1,2,3];
        执行方法后的输出结果为:[1，2,3]*/
        int[] arr={1,2,3};
        String splicing = splicing(arr);
        System.out.println(splicing);
    }
    public static String splicing(int[] num){
        String string="";//定义一个空字符串
        if (num==null){//判断数组是否为空
            return "[]";
        }
        else {
            string+="[";//初始加入[
            for (int i = 0; i < num.length-1; i++) {
                string=string+num[i]+",";//n-1个字符进行拼接
            }
            string=string+num[num.length-1]+"]";//最后一个字符拼接再加上]
        }
        return string;
    }
}
