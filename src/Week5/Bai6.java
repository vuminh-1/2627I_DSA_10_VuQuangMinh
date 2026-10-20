package Week5;

import java.io.*;
import java.util.*;

public class Bai6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i += 1;
            }
        }

        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        printArray(arr);
        return i;
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int middle = partition(arr, low, high);
        quickSort(arr, low, middle - 1);
        quickSort(arr, middle + 1, high);

    }

}
