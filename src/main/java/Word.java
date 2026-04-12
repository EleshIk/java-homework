import java.lang.reflect.Array;
import java.util.Arrays;

public class Word {
    public static <boolen> void main(String[] args) {

        System.out.println("Задание № 1");
        // Number 1
        printThreeWords();

        System.out.println("Задание № 2");
        // Number 2
        checkSumSign();

        System.out.println("Задание № 3");
        // Number 3
        printColor();

        // Number 4
        System.out.println("Задание № 4");
        compareNumbers();
        System.out.println("\n");

        // Number 5
        System.out.println("Задание № 5");
        booleanNum(3, 5);
        System.out.println("\n");

        // Number 6
        System.out.println("Задание № 6");
        printNum(-2);

        // Number 7
        System.out.println("Задание № 7");
        boolean c = booleanNumNew(1);
        System.out.println(c);
        System.out.println("\n");

        // Number 8
        System.out.println("Задание № 8");
        multyplyNumInString(2, "Ky");
        System.out.println("\n");

        // Number 9
        System.out.println("Задание № 9");
        boolean answerYear = yearLeap(2026);
        System.out.println(answerYear);
        System.out.println("\n");


        // Number 10
        System.out.println("Задание № 10");
        replaceNumArr(0,1,1,0,1,1,0);

        // Number 11
        System.out.println("Задание № 11");
        replaceNumArr100(100);

        // Number 12
        System.out.println("Задание № 12");
        replaceNumArr6( 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1);

        // Number 13
        System.out.println("Задание № 13");
        twoDimensionalArray(6);

        // Number 14
        System.out.println("Задание № 14");
        multiplyNumString(3, 2);

    }

    private static int[] multiplyNumString(int len,int initialValue) {
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;

    }


    // Number 13
    private static void twoDimensionalArray(int size) {
        int[][] matr = new int[size][size];
        for (int i = 0; i < size; i++) {
            matr[i][i] = 1;
            matr[i] [size - 1 - i] = 1;
        }
    }

    // Number 12
    private static void replaceNumArr6(int...arr) {
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    // Number 11
    private static void replaceNumArr100(int length) {
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr));
    }

    // Number 10
    private static void replaceNumArr(int... arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Number 9
    private static boolean yearLeap(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }



    // Number 8
    private static void multyplyNumInString(int a, String word) {
        for (int i = 0; i < a; i++) {
            System.out.println(word);
        }
    }

    // Number 7
    private static boolean booleanNumNew(int a) {
        if(a >= 0) {
            return true;
        } else {
            return false;
        }
    }

    // Number 6
    private static void printNum(int a) {
        if(a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
        System.out.println("\n");
    }


    // Number 5
    private static boolean booleanNum(int a, int b) {
        int c = a + b;
        if(c >= 10 && c <= 20) {
            return true;
        }
        return false;

    }


    // Number 4
    private static void compareNumbers() {
        int a = 1;
        int b = 10000000;
        if( a>= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // Number 3
    private static void printColor() {
        int value = 145;
        if(value <= 0) {
            System.out.println("Красный");
        } else if (  0 < value && value < 100 ){
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
        System.out.println("\n");
    }

    // Number 1
    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println("\n");
    }

    // Number 2
    private static void checkSumSign() {
        int a = 3;
        int b = -7;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println("\n");




    }
}
