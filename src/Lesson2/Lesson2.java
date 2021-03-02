package Lesson2;

public class Lesson2 {
    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
        fourthTask();
        printArray(fourthTask());
        fifthTask();
        int[] sixthArray = {5, 7, 5, 1, 1, 5};
        System.out.println("Проверка шестого задания");
        System.out.println(sixthTask(sixthArray));
        int[] seventhArray = {1, 2, 3, 4, 5};
        printArraySingle(seventhTask(seventhArray, 3));
    }

    static void printArray(int[][] myArray) {
        System.out.println("Проверка четвертого задания");
        for (int i = 0; i < myArray.length; i++){
            for (int j = 0; j < myArray[i].length; j++){
                System.out.print(myArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printArraySingle(int[] myArray) {
        System.out.println("Проверка седьмого задания");
        for (int i = 0; i < myArray.length; i++){
            System.out.print(myArray[i]);
            System.out.print(" ");
        }
    }

    static void firstTask() {
        int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Проверка первого задания");
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == 0) {
                firstArray[i] = 1;
            }
            else {
                firstArray[i] = 0;
            }
            System.out.print(firstArray[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    static void secondTask() {
        int[] secondArray = new int[8];
        System.out.println("Проверка второго задания");
        for (int i = 0; i < secondArray.length; i++) {
        secondArray[i] = i * 3;
        System.out.print(secondArray[i]);
        System.out.print(" ");
        }
        System.out.println();
    }

    static void thirdTask() {
        int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Проверка третьего задания");
        for (int i = 0; i < thirdArray.length; i++) {
            if (thirdArray[i] < 6) {
                thirdArray[i] = thirdArray [i] * 2;
            }
            System.out.print(thirdArray[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    static int[][] fourthTask() {
        int[][] fourthArray = new int[10][10];
        for (int i = 0; i < fourthArray.length; i++) {
                   fourthArray[i][i] = 1;
                   fourthArray[i][fourthArray.length-1-i] = 1;
        }
        return fourthArray;
    }

    static void fifthTask() {
        int[] fifthArray = { 1, 2, 2, 5, -1, 4};
        int max = 0;
        int min = 0;
        System.out.println("Проверка пятого задания");
        for (int i = 0; i < fifthArray.length; i++) {
            if (fifthArray[i] > max) {
                max = fifthArray[i];
                            }
            else if (fifthArray[i] < min) {
                min = fifthArray[i];
            }
        }
        System.out.println("Максимальное число: " + max + " Минимальное число: " + min);
    }

    static boolean sixthTask(int[] myArray) {
        int sumleft = 0;
        boolean checksum = false;
        for  (int i = 0; i <myArray.length; i++){
            sumleft = sumleft + myArray[i];
            int sumright = 0;
            for (int j = i + 1; j < myArray.length; j++) {
                sumright = sumright + myArray[j];
            }
            if (sumleft == sumright) {
                checksum = true;
                break;
            }
        }
        return checksum;
    }

    static int[] seventhTask(int[] changeArray, int n) {
        if (n < 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                int save = changeArray[0];
                for (int j = 0; j < changeArray.length -1; j++){
                    changeArray[j] = changeArray[j + 1];
                }
                changeArray[changeArray.length - 1] = save;
            }
        }
        else if (n > 0){
            for (int i = 0; i < Math.abs(n); i++) {
                int save = changeArray[changeArray.length - 1];
                for (int j = changeArray.length - 1; j > 0; j--){
                    changeArray[j] = changeArray[j - 1];
                }
                changeArray[0] = save;
            }
        }
    return changeArray;
    }
}









