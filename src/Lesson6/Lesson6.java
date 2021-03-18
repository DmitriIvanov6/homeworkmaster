package Lesson6;

public class Lesson6 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Барсик"),
                new Dog("Тузик"),
                new Dog("Мухтар")
        };
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(100);
            animals[i].swim(5);
        }
        System.out.println("Счетчик животных: " + Animal.counter);

    }

}
