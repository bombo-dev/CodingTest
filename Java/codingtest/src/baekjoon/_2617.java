package baekjoon;

import java.io.*;
import java.util.*;

public class _2617 {
    static int[] depths;
    static int maxDepth;
    static int depth;
    static int result = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> largeList = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> smallList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        depths = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            largeList.add(new ArrayList<>());
            smallList.add(new ArrayList<>());
        }

        maxDepth = (N + 1) / 2;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            largeList.get(a).add(b);
            smallList.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            depth = 0;
            visited = new boolean[N + 1];

            DFS(i, largeList);
            if(maxDepth <= depth)
                result++;

            DFS(i, smallList);
            if(maxDepth <= depth)
                result++;
        }

        System.out.print(result);

    }

    public static void DFS(int start, ArrayList<ArrayList<Integer>> list) {

        visited[start] = true;

        for (int end : smallList.get(start)) {
            depth++;
            if(!visited[end])
                DFS(end, list);
        }
    }
}
