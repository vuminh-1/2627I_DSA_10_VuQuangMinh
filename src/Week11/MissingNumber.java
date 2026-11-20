package Week11;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result01 {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Map<Integer, Integer> freqA = new HashMap<>();
        Map<Integer, Integer> freqB = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> distinctB = new ArrayList<>();
        for (int num : arr) {
            freqA.put(num, freqA.getOrDefault(num, 0) + 1);
        }

        for (int num : brr) {
            if (freqB.get(num) == null) {
                freqB.put(num, 1);
                distinctB.add(num);
            }
            else freqB.put(num, freqB.get(num) + 1);
        }

        for (int i : distinctB) {
            if (freqA.get(i) == null) result.add(i);
            else if (freqA.get(i) < freqB.get(i)) result.add(i);
        }

        Collections.sort(result);
        return result;
    }


}

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result01.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

