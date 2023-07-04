package day8_23.demo1;

public class test {
    public static void main(String[] args) {
        b c = new b();
        c.w();
        b d=new b(1,2);
    }
}

class a {
    public int a=1,b=2;
    public a(){
        System.out.println("a");
    }
    public a(int a, int b) {
        System.out.println(a+b);
    }

    static void w() {
        System.out.println("w");
    }
}

class b extends a {
    public b() {
    }
    public b(int a,int b){
        super(a,b);
    }
}
