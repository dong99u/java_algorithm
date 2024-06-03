package algorithm.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Josephus {

    public static int solution(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                Integer poll = queue.poll();
                queue.add(poll);
            }

            queue.poll();
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int solution = solution(5, 3);
        System.out.println(solution);
    }
}
