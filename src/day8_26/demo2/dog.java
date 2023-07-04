package day8_26.demo2;

public class dog extends animal implements swiming{
    public dog() {
    }

    public dog(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗会狗刨");
    }
}
