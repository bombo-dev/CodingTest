package baekjoon._1068;

import java.io.*;
import java.util.*;

class Node {
    int value;
    Node parentNode;
    ArrayList<Node> childList = new ArrayList<>();

    public Node() {
        this(0, null);
    }

    public Node(int value, Node parentNode) {
        this.value = value;
        this.parentNode = parentNode;
    }
}

public class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Node[] nodeArr;
    static int leafCount = 0;
    static int rootIndex = -1;

    public static void main(String[] args) throws IOException {
        init();
        removeNode();
        if (nodeArr[rootIndex] != null) {
            findLeafNode(nodeArr[rootIndex]);
        }
        System.out.print(leafCount);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        nodeArr = new Node[N];

        // 노드 초기화
        for (int i = 0; i < N; i++) {
            nodeArr[i] = new Node(i, null);
        }

        // 부모와 자식 관계 지정
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                rootIndex = i;
                continue;
            }

            Node currentNode = nodeArr[i];
            Node parentNode = nodeArr[parent];
            currentNode.parentNode = parentNode;

            parentNode.childList.add(currentNode);
        }
    }

    private static void removeNode() throws IOException {
        // 삭제 할 인덱스 번호
        int remove = Integer.parseInt(br.readLine());

        // 삭제 할 인덱스 번호가 rootIndex
        if (remove == rootIndex) {
            nodeArr[remove] = null;
            return;
        }

        Node removeNode = nodeArr[remove];
        removeNode.parentNode.childList.remove(removeNode);
    }

    private static void findLeafNode(Node node) {

        if (node.childList.isEmpty())
            leafCount++;

        for(Node childNode : node.childList) {
            findLeafNode(childNode);
        }
    }
}
