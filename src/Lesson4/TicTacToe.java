package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static void start() {
        char[][] field = emptyField();
        drawField(field);

        while (true) {
            doPlayerMove(field);
            drawField(field);
            if (isWin(field, 'X')) {
                System.out.println("Поздравляем, вы победитель!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Ничья");
                break;
            }

            doAICounter(field);
            drawField(field);
            if (isWin(field, 'O')) {
                System.out.println("Вы проиграли");
                break;
            }
        }
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isFreeCell(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isWin(char[][] field, char symbol) {

        //Проверка горизонтали
        for (int i = 0; i < field.length; i++) {
            int wincount = 0;
            for (int j = 0; j < field.length; j++) {
                if (symbol == field[i][j]) {
                    wincount++;
                } else if (field[i][j] != symbol && j != 0) {
                    break;
                }
                if (wincount == 4) {
                    return true;
                }
            }
        }
        //Проверка вертикали
        for (int j = 0; j < field.length; j++) {
            int wincount = 0;
            for (int i = 0; i < field.length; i++) {
                if (symbol == field[i][j]) {
                    wincount++;
                } else if (field[i][j] != symbol && i != 0) {
                    break;
                }
                if (wincount == 4) {
                    return true;
                }
            }
        }

        // Проверка левых диагоналей, для поля 5 на 5 достаточно проверить лишь 3, при условии 4 фишек в ряд
        int i = 1;
        int j = 0;
        int wincount = 0;
        while (i <= 4) {
            if (symbol == field[i][j]) {
                wincount++;
            }
            i++;
            j++;
            if (wincount == 4) {
                return true;
            }
        }
        i = 0;
        j = 0;
        wincount = 0;
        while (i <= 4) {
            if (symbol == field[i][j]) {
                wincount++;
            } else if (field[i][j] != symbol && i != 0) {
                break;
            }
            i++;
            j++;
            if (wincount == 4) {
                return true;
            }
        }
        i = 0;
        j = 1;
        wincount = 0;
        while (i <= 3) {
            if (symbol == field[i][j]) {
                wincount++;
            }
            i++;
            j++;
            if (wincount == 4) {
                return true;
            }
        }
        // Проверка правых диагоналей
        i = 0;
        j = 3;
        wincount = 0;
        while (i <= 3) {
            if (symbol == field[i][j]) {
                wincount++;
            }
            i++;
            j--;
            if (wincount == 4) {
                return true;
            }
        }
        i = 0;
        j = 4;
        wincount = 0;
        while (i <= 4) {
            if (symbol == field[i][j]) {
                wincount++;
            } else if (field[i][j] != symbol && i != 0) {
                break;
            }
            i++;
            j--;
            if (wincount == 4) {
                return true;
            }
        }
        i = 1;
        j = 4;
        wincount = 0;
        while (i <= 4) {
            if (symbol == field[i][j]) {
                wincount++;
            }
            i++;
            j--;
            if (wincount == 4) {
                return true;
            }
        }


        return false;
    }

    static void doPlayerMove(char[][] field) {
        int h, v;

        do {
            h = getCoordinate(field.length, 'h');
            v = getCoordinate(field.length, 'v');
        } while (isOccupiedCell(field, h, v));

        field[h][v] = 'X';
    }

    static int getCoordinate(int length, char symbol) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("Пожалуйста введите значение по %s...%n", symbol);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= length);

        return coordinate;
    }

    static void doAIMove(char[][] field) {
        Random random = new Random();
        int h, v;

        do {
            h = random.nextInt(5);
            v = random.nextInt(5);
        } while (isOccupiedCell(field, h, v));

        field[h][v] = 'O';


    }

    static boolean doAICounterHorizontal(char[][] field) {
        boolean movemade = false;
        for (int i = 0; i < field.length; i++) {
            int h, v;
            Random random = new Random();
            int wincount = 0;
            boolean nowinline = true;
            for (int j = 1; j <= 3; j++) {
                if (field[i][j] == 'O') {
                    nowinline = false;
                    break;
                }
            }
            for (int j = 0; j < field.length; j++) {
                if ('X' == field[i][j]) {
                    wincount++;
                } else if (field[i][j] != 'X' && j != 0) {
                    break;
                }

            }
            if (wincount >= 2 && nowinline) {
                do {
                    h = i;
                    v = random.nextInt(5);
                } while (isOccupiedCell(field, h, v));
                field[h][v] = 'O';
                movemade = true;
                break;
            }
        }
        return movemade;
    }

    static boolean doAICounterVertical(char[][] field) {
        boolean movemade = false;
        for (int j = 0; j < field.length; j++) {
            int h, v;
            Random random = new Random();
            int wincount = 0;
            boolean nowinline = false;
            for (int i = 1; i <= 3; i++) {
                if (field[i][j] == 'O') {
                    nowinline = true;
                    break;
                }
            }
            for (int i = 0; i < field.length; i++) {
                if ('X' == field[i][j]) {
                    wincount++;
                } else if (field[i][j] != 'X' && i != 0) {
                    break;
                }

            }
            if (wincount >= 2 && !nowinline) {
                do {
                    h = random.nextInt(5);
                    v = j;
                } while (isOccupiedCell(field, h, v));
                field[h][v] = 'O';
                movemade = true;
                break;
            }
        }
        return movemade;
    }


    static void doAICounter(char[][] field) {
        if (!doAICounterHorizontal(field) && !doAICounterVertical(field)) {
            doAIMove(field);
        }


    }


    static boolean isFreeCell(char[][] field, int h, int v) {
        return !isOccupiedCell(field, h, v);
    }

    static boolean isOccupiedCell(char[][] field, int h, int v) {
        return field[h][v] != '-';
    }

    static char[][] emptyField() {
        return new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'}
        };
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
