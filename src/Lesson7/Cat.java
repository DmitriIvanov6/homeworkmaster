package Lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)){
            satiety = true;
        }


    }
    public void satietyCheck (String name, boolean satiety) {
        if (satiety) {
            System.out.printf("%s сытый%n", name);
        }
        else {
            System.out.printf("%s голодный%n", name);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
