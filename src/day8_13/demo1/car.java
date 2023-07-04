package day8_13.demo1;

public class car {
    public static void main(String[] args) {
        carPerson[] car=new carPerson[3];
        carPerson c=new carPerson();
        c.num=10;
        car[0]=c;//传递地址
       /* car[1].num=20;
        car[2].num=30;*/
        carPerson a=car[0];//传递地址
        System.out.println(a);
    }
}
