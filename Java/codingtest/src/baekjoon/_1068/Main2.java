package baekjoon._1068;

import java.io.*;
import java.util.*;
public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] parent;
    static boolean[] visited;
    static boolean[] leaf;
    static int leafCount = 0;
    static int rootIndex = -1;

    static int stoi(String value){
        return Integer.parseInt(value);
    }

    public static void main(String[] args) throws IOException {
        init();
        if(removeIndex()) {
            findLeaf(rootIndex);
        }
        System.out.print(leafCount);
    }

    private static void init() throws IOException {
        N = stoi(br.readLine());
        parent = new int[N];
        visited = new boolean[N];
        leaf = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            parent[i] = stoi(st.nextToken());
            if(parent[i] == -1)
                rootIndex = i;
        }
    }

    private static boolean removeIndex() throws IOException {
        int remove = stoi(br.readLine());
        if(parent[remove] == -1)
            return false;

        parent[remove] = -2;
        return true;
    }

    private static void findLeaf(int start) {
        visited[start] = true;
        boolean isLeaf = true;

        if(parent[start] != -2) {
            for (int i = 0; i < N; i++) {
                if(!visited[i] && parent[i] == start) {
                    findLeaf(i);
                    isLeaf = false;
                }
            }

            if(isLeaf) {
                leafCount++;
            }
        }
    }
}
