package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Bai3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        insertionSort1(n, arr);

        bufferedReader.close();
    }
    public static void insertionSort1(int n, List<Integer> arr) {
        int i = 1;
        while (i <= n - 1) {
            if (arr.get(i) < arr.get(i - 1)){
                int temp = arr.get(i);
                int j = i - 1;
                while (j >= 0 && temp < arr.get(j)) {
                    arr.set(j + 1, arr.get(j));
                    printing(arr);
                    j -= 1;
                }
                arr.set(j + 1, temp);
                printing(arr);
            }
            i += 1;
        }

    }
    public static void printing(List<Integer> arr) {
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
