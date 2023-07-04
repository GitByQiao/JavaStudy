package day8_28.demo1;

public class TableTennisCoach extends coach implements say{
    public TableTennisCoach() {
    }

    public TableTennisCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练教打乒乓球");
    }

    @Override
    public void Say() {
        System.out.println("乒乓球教练说英语");
    }
}
