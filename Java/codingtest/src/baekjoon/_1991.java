package baekjoon;

import java.io.*;
import java.util.*;
class TreeNode {
    char value;
    TreeNode parent;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(char value, TreeNode parent, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.parent = parent;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
public class _1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        LinkedList<TreeNode> tree = new LinkedList<>();
        treeInit(N, tree);
        preOrderPrint(tree.get(0));
        sb.append("\n");
        inOrderPrint(tree.get(0));
        sb.append("\n");
        postOrderPrint(tree.get(0));
        System.out.print(sb);
    }

    static void treeInit(int N, LinkedList<TreeNode> tree) throws IOException {
        TreeNode rootNode = new TreeNode('A', null, null, null);
        tree.add(rootNode);

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            TreeNode parentNode = null;
            TreeNode leftNode = null;
            TreeNode rightNode = null;

            for(TreeNode node : tree) {
                if(node.value == parent) {
                    parentNode = node;
                    break;
                }
            }

            if(left != '.') {
                leftNode = new TreeNode(left, parentNode, null, null);
                parentNode.leftNode = leftNode;
                tree.add(leftNode);
            }

            if(right != '.') {
                rightNode = new TreeNode(right, parentNode, null, null);
                parentNode.rightNode = rightNode;
                tree.add(rightNode);
            }
        }
    }

    static void preOrderPrint(TreeNode node) {
        sb.append(node.value);

        if(node.leftNode == null && node.rightNode == null)
            return;

        if(node.leftNode != null) {
            preOrderPrint(node.leftNode);
        }
        if(node.rightNode != null) {
            preOrderPrint(node.rightNode);
        }
    }

    static void inOrderPrint(TreeNode node) {
        if(node.leftNode != null){
            inOrderPrint(node.leftNode);
        }
        sb.append(node.value);
        if(node.rightNode != null) {
            inOrderPrint(node.rightNode);
        }
    }

    static void postOrderPrint(TreeNode node) {

        if(node.leftNode != null) {
            postOrderPrint(node.leftNode);
        }

        if(node.rightNode != null) {
            postOrderPrint(node.rightNode);
        }

        sb.append(node.value);
    }


}
