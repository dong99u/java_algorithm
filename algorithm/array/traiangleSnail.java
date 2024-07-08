package algorithm.array;

import java.util.ArrayList;

public class traiangleSnail {

    public int[] solution(int n) {

        int[][] arr = new int[n][n];

        int[] dx = { 1, 0, -1 };
        int[] dy = { 0, 1, -1 };
        int dirNum = 0;

        int currX = 0, currY = 0;

        for (int i = 1; i <= (n * (n + 1)) / 2; i++) {
            arr[currX][currY] = i;

            int nextX = currX + dx[dirNum];
            int nextY = currY + dy[dirNum];

            if (mustTurn(nextX, nextY, arr, n)) {
                dirNum = (dirNum + 1) % 3;
                nextX = currX + dx[dirNum];
                nextY = currY + dy[dirNum];
            }

            currX = nextX;
            currY = nextY;

        }

        ArrayList<Integer> answer;

        answer = convertTo1dArray(arr, n);

        return answer.stream().mapToInt(i -> i).toArray();

    }

    // 돌아아하면 true를 뱉는 함수
    public boolean mustTurn(int nextX, int nextY, int[][] matrix, int n) {
        boolean result = false;

        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n ||
                matrix[nextX][nextY] != 0) {
            result = true;
        }

        return result;
    }

    public ArrayList<Integer> convertTo1dArray(int[][] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                result.add(arr[i][j]);
            }
        }

        return result;


    }

    public static void main(String[] args) {
        traiangleSnail ts = new traiangleSnail();
        int[] result = ts.solution(4);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
