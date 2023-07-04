package day8_28.demo1;

public abstract class coach extends people{
    public coach() {
    }

    public coach(String name, int age) {
        super(name, age);
    }
    public abstract void teach();
}
