import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class Homework_01 {

    public static void main(String[] args) {

        int[] arr = new int[100000];

        Random random = new Random();

       for (int i = 0; arr.length > i; i++ ) {
           int RandomNumber = random.nextInt(1000);
           arr[i] = RandomNumber;
       }


        long startTime = System.nanoTime();
        bubbleSort(arr);
        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
        selectionSort (arr);

        System.out.println(System.nanoTime() - startTime);

        startTime = System.nanoTime();
       insertionSort (arr);
        System.out.println(System.nanoTime() - startTime);

    }

    private static void insertionSort(int[] arr) {

        for (int left = 0; left < arr.length; left++) {
            int value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {

        boolean IsSorted = false;
        int temp = 0;

        while (!IsSorted){
            IsSorted = true;
        for (int i = 0; arr.length - 1 > i; i++) {

            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
                IsSorted = false;
            }

            }
        }

        System.out.println(Arrays.toString(arr));

    }


    public static void selectionSort (int[] arr){
        int min, temp;

        for (int i = 0; i < arr.length-1; i++){
            min = i;
            for (int scan = i+1; scan < arr.length; scan++){
                if (arr[scan] < arr[min])
                    min = scan;
            }

            temp = arr[min];
            arr[min] =arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }


}
