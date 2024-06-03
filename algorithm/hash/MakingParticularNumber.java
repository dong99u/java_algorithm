package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class MakingParticularNumber {
    public boolean solution(int[] arr, int target) {
        boolean answer = false;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i : arr) {
            hashMap.put(i, i);
        }

        for (Integer i : hashMap.keySet()) {
            int rest = target - i;
            if (hashMap.containsKey(rest) && hashMap.get(rest) != i) {
                answer = true;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MakingParticularNumber makingParticularNumber = new MakingParticularNumber();
        int[] arr = {2, 3, 5, 9};
        int target = 10;
        System.out.println(makingParticularNumber.solution(arr, target));
    }
}
