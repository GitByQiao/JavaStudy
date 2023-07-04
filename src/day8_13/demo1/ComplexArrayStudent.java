package day8_13.demo1;

public class ComplexArrayStudent {
    //学生的属性：学号，姓名，年龄。
    int id;
    String name;
    int age;
    public ComplexArrayStudent() {
    }
    public ComplexArrayStudent(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
