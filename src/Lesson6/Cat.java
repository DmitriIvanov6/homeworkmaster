package Lesson6;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, 200, -1);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Наши коты не плавают!");
    }

}
