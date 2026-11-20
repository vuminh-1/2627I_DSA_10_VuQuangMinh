package Week11;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> result = new ArrayList<>();
        TreeSet<Element> set = new TreeSet<>();
        Element mid = new Element();
        for (int i = 0; i < a.size(); i++) {
            Element current = new Element(a.get(i), i);
            if (set.isEmpty()) {
                mid =  current;
                set.add(current);
                result.add(current.value / 1.0);
            }
            else {
                set.add(current);
                if ((set.size() - 1) % 2 != 0){
                    if (current.compareTo(mid) < 0) {
                        mid = set.lower(mid);
                        result.add((mid.value + set.higher(mid).value) / 2.0);
                    }
                    else {
                        result.add((mid.value + set.higher(mid).value)/ 2.0);
                    }
                }
                else {
                    if (current.compareTo(mid) > 0) {
                        mid = set.higher(mid);
                    }
                    result.add(mid.value / 1.0);
                }
            }
        }



        return result;
    }

}

class Element implements Comparable<Element>{
    int value;
    int index;
    public Element(){}
    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element other) {
        if (this.value != other.value) return Integer.compare(this.value, other.value);
        else return Integer.compare(this.index, other.index);
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

        List<Double> result = Result.runningMedian(a);

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

