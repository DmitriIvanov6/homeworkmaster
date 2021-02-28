package Lesson1;

public class Lesson1 {

    public static void main(String[] args ){
        byte mybyte = 10;
        short myshort = 352;
        int myinteger = 1;
        long mylong = 5000;
        float myfloat = 1.5f;
        double mydouble = 10.23;
        boolean meboolean = true;
        char mychar = 'D';
        String mystring = "Hello world!";
        positnegat(2);
        nameString("указанное_имя");
        checkyear(400);
    }

    static float calculation(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    static boolean checksum(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <= 20;

    }

    static void positnegat(int a){
        if(a>= 0){
            System.out.println("Число положительное");
        }
        else {
            System.out.println("Число отрицательное");
        }
    }

    static boolean positnegatbool(int a) {
        return a < 0;

    }

    static void nameString(String a){
        System.out.println("«Привет, " + a + "!»");
    }

    static void checkyear( int a){
        if( a % 4 == 0 && a % 100 != 0 || a % 400 == 0 ){
            System.out.println("Год високосный");
        }
        else{
            System.out.println("Год невисокосный");
        }


    }

}
