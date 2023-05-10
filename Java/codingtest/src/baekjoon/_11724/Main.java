package baekjoon._11724;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        visited = new boolean[N + 1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }

    static void solve() {
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                count++;
                bfs(i);
            }
        }
        System.out.print(count);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int go = q.poll();

            for(int end : graph.get(go)) {
                if(!visited[end]) {
                    visited[end] = true;
                    q.offer(end);
                }
            }
        }
    }
    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
