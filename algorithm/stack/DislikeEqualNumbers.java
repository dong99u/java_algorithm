package algorithm.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DislikeEqualNumbers {

    public int[] solution(int []arr) {
        Stack<Integer> numbers = new Stack<>();

        List<Integer> answer = new ArrayList<>();

        for (int i : arr) {
            if (numbers.isEmpty()) {
                numbers.push(i);
            } else if (!numbers.isEmpty() && numbers.peek() == i) {
                continue;
            } else {
                answer.add(numbers.pop());

                numbers.push(i);
            }
        }

        answer.add(numbers.pop());

        return answer.stream().mapToInt(i -> i).toArray();

    }

}
