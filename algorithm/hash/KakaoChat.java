package algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class KakaoChat {
    public String[] solution(String[] record) {

        HashMap<String, String> idMap = new HashMap<>();

        for (String s : record) {
            String[] s1 = s.split(" ");
            String inst = s1[0];
            if (inst.equals("Enter")) {
                String id = s1[1];
                String name = s1[2];
                idMap.put(id, name);
            }
            if (inst.equals("Change")) {
                String id = s1[1];
                String name = s1[2];
                if (idMap.containsKey(id)) {
                    idMap.put(id, name);
                }
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] s1 = s.split(" ");
            if (s1[0].equals("Enter")) {
                String name = idMap.get(s1[1]);
                answer.add(name + "님이 들어왔습니다.");
            } else if (s1[0].equals("Leave")) {
                String name = idMap.get(s1[1]);
                answer.add(name + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
