import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color){
        this.name=name;
        this.age=age;
        this.color=color;
    }

    public static void voise(Cat cat){
        System.out.println(cat.name + ": M-e-o-u!!!");
    }

    public static void jump(Cat cat){
        System.out.println(cat.name + ": jump");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }
}
