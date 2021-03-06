package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        guessNumber();
        guessWord();

    }

    public static void guessNumber() {
        Random random = new Random();
        byte cont = 1;
        while (cont == 1) {
            int number = random.nextInt(10);
            System.out.println("Угадайте число от 0 до 9");
            System.out.println("У вас есть 3 попытки");
            System.out.println("Введите число");
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i <= 2; i++) {
                int guess = scanner.nextInt();
                if (guess > number) {
                    System.out.println("Вы не угадали, загаданное число меньше.");
                    System.out.println("Попыток осталось: " + (2 - i));

                } else if (guess < number) {
                    System.out.println("Вы не угадали, загаданное число больше.");
                    System.out.println("Попыток осталось: " + (2 - i));
                } else {
                    System.out.println("Вы угадали!");
                    break;
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            cont = scanner.nextByte();
        }
    }

    static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        String word = words[random.nextInt(words.length)];
        System.out.println("Угадайте слово. Введите ваш вариант ниже.");
        char[] hint = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        char[] wordarray = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}; /* Чтобы добавить доп. символы после слова и избежать ошибки*/
        boolean check = false;
        boolean mismatch = true;
        for (int i = 0; i < word.length(); i++) {
            wordarray[i] = word.charAt(i);
        }
        while (!check) {
            Scanner scanner = new Scanner(System.in);
            String guess = scanner.nextLine();
            for (int i = 0; i < guess.length(); i++) {
                if (guess.length() > 15) {
                    System.out.println("Слово слишком длинное. Введите не более 15 символов");
                    break;
                } else if (wordarray[i] == guess.charAt(i) && word.length() == guess.length()) {
                    hint[i] = wordarray[i];
                } else if (wordarray[i] == guess.charAt(i) && word.length() != guess.length()) {
                    hint[i] = wordarray[i];
                    mismatch = false;
                } else {
                    mismatch = false;
                }
            }
            boolean mismatch2 = true; /*Эта проверка т.к. если выставить mismatch = true выше, то при совпадении последнего символа, засчитается победа*/
            for (int i = 0; i < word.length(); i++) {
                if (hint[i] != word.charAt(i)) {
                    mismatch2 = false;
                    break;
                }
            }
            if (mismatch2 && word.length() == guess.length()) {
                check = true;
            } else if (!mismatch) {
                System.out.println("Вы  не угадали! Вот подсказка, угаданные символы стоят на своих местах:");
                System.out.println(hint);
            }
        }
        System.out.println("Вы угадали!");
    }
}