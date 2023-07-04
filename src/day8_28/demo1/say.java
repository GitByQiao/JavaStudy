package day8_28.demo1;

public interface say {
    public abstract void Say();
    public static void Say2(){};
    public default void Say3(){Say3_1();};
    public default void Say3_1(){};
    //public void Say4();
}
