package algorithm.tree;

public class TravalTree {
    public static String[] solution(int[] nodes) {
        StringBuilder preorderStringBuilder = new StringBuilder();
        StringBuilder inorderStringBuilder = new StringBuilder();
        StringBuilder postorderStringBuilder = new StringBuilder();

        preorder(0, nodes, preorderStringBuilder);
        inorder(0, nodes, inorderStringBuilder);
        postorder(0, nodes, postorderStringBuilder);


        return new String[]{preorderStringBuilder.toString(), inorderStringBuilder.toString(), postorderStringBuilder.toString()};
    }

    public static String preorder(int index, int[] nodes, StringBuilder sb) {
        // 종료 조건
        if (index >= nodes.length) {
            return null;
        }

        sb.append(nodes[index] + " ");
        preorder(index * 2 + 1, nodes, sb);
        preorder(index * 2 + 2, nodes, sb);

        return sb.toString();

    }

    public static String inorder(int index, int[] nodes, StringBuilder sb) {
        // 종료 조건
        if (index >= nodes.length) {
            return null;
        }

        inorder(index * 2 + 1, nodes, sb);
        sb.append(nodes[index] + " ");
        inorder(index * 2 + 2, nodes, sb);

        return sb.toString();

    }

    public static String postorder(int index, int[] nodes, StringBuilder sb) {
        // 종료 조건
        if (index >= nodes.length) {
            return null;
        }

        postorder(index * 2 + 1, nodes, sb);
        postorder(index * 2 + 2, nodes, sb);
        sb.append(nodes[index] + " ");

        return sb.toString();

    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};

        String[] result = solution(nodes);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
