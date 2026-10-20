package Week5;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result1 {
    public static int findMedian(List<Integer> arr) {
        quickSort(arr, 0, arr.size() - 1);
        return arr.get(arr.size() / 2);
    }

    public static void quickSort(List<Integer> arr, int low, int high) {
        if (low >= high) return;
        int middle = partition(arr, low, high);
        if (middle == arr.size() / 2) return;
        else if (middle > arr.size() / 2) {
            quickSort(arr, low, middle - 1);
        }
        else {
            quickSort(arr, middle + 1, high);
        }


    }
    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                int temp = arr.get(j);
                arr.set(j, arr.get(i));
                arr.set(i, temp);
                i += 1;
            }
        }
        int temp = pivot;
        arr.set(high, arr.get(i));
        arr.set(i, temp);

        return i;
    }

}

public class Bai7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result1.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

