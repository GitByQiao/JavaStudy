package day8_26.demo2;

public class test {
    public static void main(String[] args) {
        dog dog=new dog(12,"大黄");
        rabbit rabbit=new rabbit(10,"小白");
        frog frog=new frog(5,"小绿");
        System.out.println(dog.getAge()+dog.getName());dog.eat();dog.swim();
        System.out.println(rabbit.getAge()+rabbit.getName());rabbit.eat();
        System.out.println(frog.getAge()+frog.getName());frog.eat();frog.swim();
    }
}
