package algorithm.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class CardPile {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        Queue<String> card1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> card2 = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        while (!goalDeque.isEmpty()) {
            if (!card1.isEmpty() && card1.peek().equals(goalDeque.peek())) {
                card1.poll();
                goalDeque.poll();
            } else if (!card2.isEmpty() && card2.peek().equals(goalDeque.peek())) {
                card2.poll();
                goalDeque.poll();
            } else {
                break;
            }
        }

        answer = goalDeque.isEmpty() ? "Yes" : "No";


        return answer;
    }
}
