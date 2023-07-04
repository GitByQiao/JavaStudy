package day8_5.demo1;

import java.util.Scanner;

public class copeNewArr {//从开始到终止范围复制数字到新数组
    public static void main(String[] args) {
        int[] arr1={1,10,15,17,30,61,80};
        Scanner sc=new Scanner(System.in);
        int from=sc.nextInt();
        int to=sc.nextInt();
        int[] arr2=copyOfRange(arr1,from,to);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
    }
    public static int[] copyOfRange(int[] arr1,int from, int to){
        int[] arr2=new int[to-from];
        for (int i = from,j=0; i < to; i++,j++) {
            arr2[j]=arr1[i];
        }
        return arr2;
    }
}
