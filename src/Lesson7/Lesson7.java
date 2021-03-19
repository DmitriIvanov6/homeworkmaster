package Lesson7;

public class Lesson7 {

    public static void main(String[] args) {
        Cat[] cats ={
                new Cat("Барсик1", 20),
                new Cat("Барсик2", 15),
                new Cat("Барсик3", 10),
                new Cat("Барсик4", 20),
                new Cat("Барсик5", 40),
                new Cat("Барсик6", 35)
        };
        Plate plate = new Plate(100);
        plate.info();
        for (int i = 0; i< cats.length; i++) {
            cats[i].eat(plate);
            cats[i].satietyCheck(cats[i].getName(), cats[i].isSatiety());
        }
        plate.info();
        plate.increaseFood(20);
        plate.info();
    }
}
