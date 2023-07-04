package day8_26.demo1;

public class Person {
   private String name;
   private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    /*public void keepPet(Dog dog,String something){
        System.out.println("年龄为"+getAge()+"岁的"+getName()+"养了一只"+dog.getColor()+"颜色的"+dog.getAge()+"的狗");
        dog.eat(something);
    }
    public void keepPet(Cat cat,String something){
        System.out.println("年龄为"+getAge()+"岁的"+getName()+"养了一只"+cat.getColor()+"颜色的"+cat.getAge()+"猫");
        cat.eat(something);
    }*/
    public void keepPet(Animal animal,String something){
        if (animal instanceof Dog) {//判断父类类型是不是狗
            System.out.println("年龄为"+getAge()+"岁的老王养了一只"+animal.getColor()+"颜色的"+animal.getAge()+"岁的狗");
            animal.eat(something);
        }else if (animal instanceof Cat){
            System.out.println("年龄为"+getAge()+"岁的老李养了一只"+animal.getColor()+"颜色的"+animal.getAge()+"岁的猫");
            animal.eat(something);
        }else {
            System.out.println("没有该动物");
        }
    }

}
