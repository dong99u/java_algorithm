package algorithm.hash;

import java.util.HashMap;

public class Sale {
    public int solution(String[] want, int[] number, String[] discount) {
        final int MAX_COUNT = 10;

        int answer = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            hashMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - MAX_COUNT + 1; i++) {
            HashMap<String, Integer> tempHashMap = new HashMap<>();
            for (int j = 0; j < MAX_COUNT; j++) {
                if (tempHashMap.containsKey(discount[i + j])) {
                    tempHashMap.put(discount[i + j], tempHashMap.get(discount[i + j]) + 1);
                } else {
                    tempHashMap.put(discount[i + j], 1);
                }
            }

            if (tempHashMap.equals(hashMap)) {
                answer += 1;
            }
        }

        return answer;
    }


}
