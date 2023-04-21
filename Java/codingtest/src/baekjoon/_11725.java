package baekjoon;

import java.io.*;
import java.util.*;
public class _11725 {
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited[1] = true;

        dfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int start) {

        for(int end : list.get(start)) {
            if(!visited[end]) {
                visited[end] = true;
                parent[end] = start;
                dfs(end);
            }
        }
    }
}
