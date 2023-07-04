package day8_26.demo1;

public class test {
    public static void main(String[] args) {
        Animal animal=new Animal();
        /*Cat cat=new Cat(3,"灰");
        Dog dog=new Dog(2,"黑");
        Person person1=new Person("老王",30);
        Person person2= new Person("老李",25);
        person1.keepPet(dog,"吃大骨头");
        person2.keepPet(cat,"吃小鱼干");*/
        /*Animal animal1 = new Animal(3, "灰");
        Person person=new Person("老王",25);
        person.keepPet(animal1,"小鱼");*/
        Dog dog= new Dog(2,"黑");
        Cat cat=new Cat(3,"灰");
        Person person=new Person("老王",30);
        person.keepPet(dog,"骨头");
        Person person2=new Person("老李",25);
        person2.keepPet(cat,"鱼");
        dog.lookHome();
        cat.catchMouse();
    }
}
