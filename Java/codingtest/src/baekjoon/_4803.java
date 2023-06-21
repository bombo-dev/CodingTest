package baekjoon;

import java.io.*;
import java.util.*;
public class _4803 {
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean isCycle;
    static int nodeCount;
    static int test = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int maxTree = 0;
            if(V == 0 && E == 0)
                break;

            test++;

            init(V, E);
            for(int i = 1; i < V + 1; i++) {
                isCycle = false;
                nodeCount = 0;
                if(!visited[i]) {
                    findCycle(i);
                    if(!isCycle) {
                        maxTree++;
                    }
                }
            }

            if(maxTree > 1) {
                sb.append("Case " + test + ": A forest of " + maxTree + " trees.").append("\n");
            } else if(maxTree == 1) {
                sb.append("Case " + test + ": There is one tree.").append("\n");
            } else {
                sb.append("Case " + test + ": No trees.").append("\n");
            }
        }

        System.out.print(sb);
    }

    static void init(int V, int E) throws IOException {
        visited = new boolean[V + 1];
        parent = new int[V + 1];
        graph = new ArrayList<>();

        for(int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    static void findCycle(int start) {
        visited[start] = true;
        nodeCount++;
        for(int end : graph.get(start)) {
            if(findParent(start) == findParent(end))
                isCycle = true;
            else {
                unionParent(start, end);
                visited[end] = true;
                findCycle(end);
            }
        }
    }

    static int findParent(int a) {
        if(parent[a] != a) {
            parent[a] = findParent(parent[a]);
        }

        return parent[a];
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        parent[b] = a;
    }
}
