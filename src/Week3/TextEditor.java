package Week3;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        Stack<String> S = new Stack<>();
        Stack<String> temporaryDeletion = new Stack<>();
        int latestLengthOfAppending = 0;
        int latestLengthOfDeleting = 0;
        Stack<Integer> latestAction = new Stack<>();
        for (int i = 0; i < q; i++) {
            int message = scanner.nextInt();
            if (message == 1) {
                latestAction.push(1);
                String appendingString = scanner.next();
                latestLengthOfAppending = appendingString.length();
                for (String s : appendingString.split("")) {
                    S.push(s);
                }
            }
            else if (message == 2) {
                latestAction.push(2);
                int k = scanner.nextInt();
                while (k != 0) {
                    temporaryDeletion.push(S.pop());
                    k -= 1;
                }
            }
            else if (message == 3) {
                int k = scanner.nextInt();
                System.out.println(S.elementAt(k - 1));
            }
            else {
                if (latestAction.peek() == 1) {
                    for (int j = 0; j < latestLengthOfAppending; j++) {
                        S.pop();
                    }
                }
                else {
                    while (!temporaryDeletion.empty()) {
                        S.push(temporaryDeletion.pop());
                    }
                }
                latestAction.pop();
            }
        }
    }
}

