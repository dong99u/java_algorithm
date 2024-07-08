package algorithm.set;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionFind {
    public static ArrayList<Boolean> solution(int k, int[][] operations) {
        int[] sets = makeSets();
        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] operation : operations) {
            switch (operation[0]) {
                case 0:
                    int indexA = operation[1];
                    int indexB = operation[2];

                    sets = union(sets, indexA, indexB);
                    break;

                case 1:
                    int a = operation[1];
                    int b = operation[2];
                    while (true) {
                        if (a == sets[a] ) {
                            break;
                        }

                        a = sets[a];
                    }

                    while (true) {
                        if (b == sets[b]) {
                            break;
                        }

                        b = sets[b];
                    }

                    if (a == b) {
                        answer.add(true);
                    } else {
                        answer.add(false);
                    }
                    break;


                default:
                    break;

            }
        }


        return answer;
    }

    private static int[] makeSets() {
        int[] sets = new int[3];

        for (int i = 0; i < sets.length; i++) {
            sets[i] = i;
        }

        return sets;
    }

    private static int[] union(int[] array, int indexA, int indexB) {
        if (indexA > indexB) {
            array[indexB] = indexA;
        } else {
            array[indexA] = indexB;
        }

        return array;

    }

    public static void main(String[] args) {

        int[][] operations = {
                {0, 0, 1},
                {1, 1, 2},
                {0, 1, 2},
                {1, 0, 2}
        };

        ArrayList<Boolean> solution = solution(4, operations);
        System.out.println("solution = " + solution);
    }
}
