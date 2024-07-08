package algorithm.string;

public class ReverseString {
    public int[] solution(long n) {
        int[] answer = {};

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 10);
            n /= 10;
        }

        answer = sb.toString().chars().map(c -> c - '0').toArray();

        return answer;
    }
}
