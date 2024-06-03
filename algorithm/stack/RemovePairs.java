package algorithm.stack;

import java.util.ArrayDeque;

public class RemovePairs {
    public static int solution(String s) {
        int answer = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (peek.equals(c)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);

        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution("cdcd");
        System.out.println(solution);
    }
}
