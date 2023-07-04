package day8_28.demo1;

public abstract class Athletes extends people{
    public Athletes() {
    }

    public Athletes(String name, int age) {
        super(name, age);
    }
    public abstract void study();
}
