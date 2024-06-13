package algorithm.tree;

public class PredictedBrackets {
    public int solution(int n, int a, int b)
    {
        int count = (int) (Math.log(n) / Math.log(2));

        int startNum = (int) (Math.pow(2, count) - 1);
        int num1 = startNum + a - 1;
        int num2 = startNum + b - 1;

        int answer = 0;

        while (num1 != num2) {
            num1 = (num1 - 1) / 2;
            num2 = (num2 - 1) / 2;

            answer ++;
        }

        return answer;
    }

    public static void main(String[] args) {
        PredictedBrackets predictedBrackets = new PredictedBrackets();
        System.out.println(predictedBrackets.solution(8, 4, 7));
    }
}
