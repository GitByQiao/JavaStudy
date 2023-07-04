package day8_26.demo2;

public class frog extends animal implements swiming{
    public frog() {
    }

    public frog(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("青蛙吃虫子");
    }

    @Override
    public void swim() {
        System.out.println("青蛙蛙泳");
    }
}
