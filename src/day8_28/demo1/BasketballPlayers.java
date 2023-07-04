package day8_28.demo1;

public class BasketballPlayers extends Athletes{
    public BasketballPlayers() {
    }

    public BasketballPlayers(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("篮球运动员学习打篮球");
    }

}
