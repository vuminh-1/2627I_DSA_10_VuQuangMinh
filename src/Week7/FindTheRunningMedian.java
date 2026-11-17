package Week7;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result01 {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            if (maxHeap.isEmpty() || a.get(i) <= maxHeap.peek()) {
                maxHeap.add(a.get(i));
            }
            else {
                minHeap.add(a.get(i));
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (i == 0) result.add(Double.valueOf(a.get(0)));
            else if (i == 1) result.add(Math.round((a.get(0) + a.get(1)) / 2.0 * 10) / 10.0);
            else if (i % 2 == 0) result.add(Double.valueOf(maxHeap.peek()));
            else result.add(Math.round((maxHeap.peek() + minHeap.peek()) / 2.0 * 10) / 10.0);
        }
        return result;
    }

}

public class FindTheRunningMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result01.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
