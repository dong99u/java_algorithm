package algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class FindWayGame {
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = makeBT(nodeinfo);

        ArrayList<Integer> preOrder = preOrder(nodes[0], new ArrayList<Integer>());
        ArrayList<Integer> postOrder = postOrder(nodes[0], new ArrayList<Integer>());

        int[][] answer = new int[2][];

        int[] preOrderResult = preOrder.stream().mapToInt(i -> i).toArray();
        int[] postOrderResult = postOrder.stream().mapToInt(i -> i).toArray();

        answer[0] = preOrderResult;
        answer[1] = postOrderResult;

        return answer;

    }

    private static ArrayList<Integer> preOrder(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return null;
        }

        result.add(node.number);
        preOrder(node.left, result);
        preOrder(node.right, result);

        return result;
    }

    private static ArrayList<Integer> postOrder(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return null;
        }

        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.number);

        return result;
    }


    private static Node[] makeBT(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);

            nodes[i] = node;
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y != o2.y) {
                return Integer.compare(o2.y, o1.y);
            }
            return Integer.compare(o1.x, o2.x);
        });

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;

            while (true) {
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        FindWayGame findWayGame = new FindWayGame();
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] result = findWayGame.solution(nodeinfo);

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }


    public static class Node {
        int number;
        int x;
        int y;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
}
