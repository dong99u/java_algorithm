package algorithm.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class StockPrice {
    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack stack = new Stack();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[(int) stack.peek()]) {
                int j = (int) stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = (int) stack.pop();
            answer[j] = n - 1 - j;
        }
        return answer;
    }
}
