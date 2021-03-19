package Lesson6;

public abstract class Animal {
    private final String name;
    private final int maxrundistance, maxswimdistance;
    public static int counter;

    public Animal(String name, int maxrundistance, int maxswimdistance) {
        this.name = name;
        this.maxrundistance = maxrundistance;
        this.maxswimdistance = maxswimdistance;
        counter++;

    }

    public void run(int distance) {
        if (distance <= maxrundistance) {
            System.out.printf("%s пробежал %s метров.%n", name, distance);
        } else {
            System.out.printf("%s столько не пробежать%n", name);
        }

    }

    public void swim(int distance) {
        if (distance <= maxswimdistance) {
            System.out.printf("%s проплыл %s метров.%n", name, distance);
        } else {
            System.out.printf("%s столько не проплыть%n", name);
        }
    }
}
