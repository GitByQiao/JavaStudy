package day8_26.demo2;

public class rabbit extends animal{
    public rabbit() {
    }

    public rabbit(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("兔子吃萝卜");
    }

}
