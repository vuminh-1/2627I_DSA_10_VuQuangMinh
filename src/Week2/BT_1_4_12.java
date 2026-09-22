package Week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BT_1_4_12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String lineA = scan.nextLine().trim();
        String lineB = scan.nextLine().trim();

        int[] a = parseArray(lineA);
        int[] b = parseArray(lineB);

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");

                int current = a[i];
                while (i < a.length && a[i] == current) i++;
                while (j < b.length && b[j] == current) j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        scan.close();
    }

    private static int[] parseArray(String line) {
        if (line.isEmpty()) return new int[0];
        String[] parts = line.split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (String part : parts) {
            if (!part.isEmpty()) {
                list.add(Integer.parseInt(part));
            }
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }
}