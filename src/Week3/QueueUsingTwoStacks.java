package Week3;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int message = scanner.nextInt();
            if (message == 1) {
                stackIn.push(scanner.nextInt());
            }
            else if (message == 2) {
                if (stackOut.isEmpty()) {
                    while (!stackIn.isEmpty()) {
                        stackOut.push(stackIn.pop());
                    }
                    stackOut.pop();
                }
                else {
                    stackOut.pop();
                }
            }
            else {
                if (stackOut.isEmpty()) {
                    while (! stackIn.isEmpty()) {
                        stackOut.push(stackIn.pop());
                    }
                    System.out.println(stackOut.peek());
                }
                else {
                    System.out.println(stackOut.peek());
                }
            }
        }
    }
}

