package algorithm.stack;

import java.util.Stack;

public class RotateParentheses {
    public static int solution(String s) {
        int answer = 0;
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (sb.charAt(j) == '(' || sb.charAt(j) == '[' || sb.charAt(j) == '{') {
                    stack.push(String.valueOf(sb.charAt(j)));
                } else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    if (sb.charAt(j) == ')' && stack.peek().equals("(")) {
                        stack.pop();
                    } else if (sb.charAt(j) == ']' && stack.peek().equals("[")) {
                        stack.pop();
                    } else if (sb.charAt(j) == '}' && stack.peek().equals("{")) {
                        stack.pop();
                    }
                }
                if (j == n - 1 && stack.isEmpty()) {
                    flag = true;
                }
            }
            if (flag) {
                answer += 1;
            }
            char temp = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(temp);

        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution("[](){}");
        System.out.println(solution);
    }
}
