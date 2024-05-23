package algorithm.sort;

import java.util.Arrays;
import java.util.Collections;

public class DistinctSort {

    public static void main(String[] args) {


    }
    private int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
