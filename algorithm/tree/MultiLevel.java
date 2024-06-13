package algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiLevel {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> tree = new HashMap<>();
        HashMap<String, Double> profit = new HashMap<>();

        tree.put("center", null);

        for (int i = 0; i < enroll.length; i++) {
            String enrolled = enroll[i];
            String referraled = referral[i];

            if (!profit.containsKey(enrolled)) {
                profit.put(enrolled, 0.0);
            }

            if (!tree.containsKey(enrolled)) {
                tree.put(enrolled, referraled);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int a = amount[i] * 100;

            while (!s.equals("-")) {
                double profitAmount = Math.floor(a * 0.1);
                double remainAmount = a - profitAmount;

                if (profitAmount < 1) {
                    profit.put(s, profit.get(s) + profitAmount + remainAmount);
                    break;
                }

                if (!profit.containsKey(s)) {
                    profit.put(s, 0.0);
                }

                profit.put(s, profit.get(s) + remainAmount);
                s = tree.get(s);
                a = (int) profitAmount;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (String s : enroll) {
            if (profit.containsKey(s)) {
                answer.add((int) Math.floor(profit.get(s)));
            } else {
                answer.add(0);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        MultiLevel multiLevel = new MultiLevel();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] result = multiLevel.solution(enroll, referral, seller, amount);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
