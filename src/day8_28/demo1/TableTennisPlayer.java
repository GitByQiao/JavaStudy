package day8_28.demo1;

public class TableTennisPlayer extends Athletes implements say{
    public TableTennisPlayer() {
    }

    public TableTennisPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("乒乓球运动员学习打乒乓球");
    }

    @Override
    public void Say() {
        System.out.println("乒乓球运动员说英语");
    }
}
