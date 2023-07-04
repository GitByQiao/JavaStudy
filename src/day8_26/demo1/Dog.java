package day8_26.demo1;

public class Dog extends Animal{
    int age=0;
    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }
//    public int getAge(){
//        return age;
//    }
    @Override
    public void eat(String something){
        //setAge(20);
        System.out.println(getAge()+"岁的"+getColor()+"颜色的狗两只前腿死死的抱住"+something+"猛吃");
    }
    public void lookHome(){
        System.out.println("狗看家");
    }
}
