package algorithm.hash;

import java.util.HashMap;

public class Player {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : completion) {
            if (hashMap.containsKey(s)) {
                hashMap.put(s, hashMap.get(s) + 1);
            } else {
                hashMap.put(s, 1);
            }
        }

        for (String s : participant) {
            if (hashMap.containsKey(s)) {
                if (hashMap.get(s) == 0) {
                    answer = s;
                    break;
                } else {
                    hashMap.put(s, hashMap.get(s) - 1);
                }
            } else {
                answer = s;
                break;
            }
        }
        return answer;
    }
}
