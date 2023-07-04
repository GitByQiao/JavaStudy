package day8_29.demo1;

import java.util.Random;

public class randomArr {
    public static void main(String[] args) {
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            int r = random.nextInt(data.length);
            int temp = data[r];
            data[r] = data[i];
            data[i] = temp;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println("");
        int[][] randomData=new int[4][4];
        int count=0;
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                randomData[i][j]=data[count];
                count++;
                System.out.print(randomData[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
