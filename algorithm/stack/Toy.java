package algorithm.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Toy {
    public static int solution(int[][] board, int[] moves) {

        int answer = 0;

        Stack<Integer> pocket = new Stack<>();

        ArrayList<Stack<Integer>> array = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < cols; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = rows - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    stack.push(board[j][i]);
                }
            }

            array.add(stack);
        }

        for (int move : moves) {
            if (!array.get(move - 1).isEmpty()) {
                Integer pop = array.get(move - 1).pop();
                if (!pocket.empty() && pop.equals(pocket.peek())) {
                    pocket.pop();
                    answer += 2;
                } else {
                    pocket.push(pop);
                }
            }
        }

        return answer;

    }
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int result = solution(board, moves);
        System.out.println("Result: " + result);
    }

}
