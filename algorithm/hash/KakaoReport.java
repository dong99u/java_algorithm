package algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class KakaoReport {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> mailMap = new HashMap<>();

        for (String s : report) {
            String[] s1 = s.split(" ");
            String from = s1[0];
            String to = s1[1];

            if (!reportMap.containsKey(to)) {
                reportMap.put(to, new HashSet<>());
            }
            reportMap.get(to).add(from);
        }

        for (String id : id_list) {
            mailMap.put(id, 0);
        }

        reportMap.entrySet().stream().forEach(
                e -> {
                    if (e.getValue().size() >= k) {
                        e.getValue().stream().forEach(
                                entry -> mailMap.put(entry, mailMap.get(entry) + 1)
                        );
                    }
                }
        );

        ArrayList<Integer> answer = new ArrayList<>();

        for (String id : id_list) {
            Integer mailCount = mailMap.get(id);
            answer.add(mailCount);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        KakaoReport kakaoReport = new KakaoReport();

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] result = kakaoReport.solution(id_list, report, k);

        for (int i : result) {
            System.out.println(i);
        }

    }
}
