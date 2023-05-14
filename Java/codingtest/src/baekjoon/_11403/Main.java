package baekjoon._11403;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[][] graph;
    static int N;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    list.get(i).add(j);
            }
        }
    }

    static void print() {
        for(int i = 1; i <= N; i++) {
            for(int value : list.get(i)) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static void solve() {
        for(int i = 1; i <= N; i++) {
            bfs(i);
        }

        resultPrint();
    }

    static void bfs(int parent) {
        Queue<Integer> q = new LinkedList<>();

        for(int value : list.get(parent)) {
            q.offer(value);
            graph[parent][value] = 1;
        }

        while(!q.isEmpty()) {
            int end = q.poll();

            for(int value : list.get(end)) {
                if(graph[end][value] == 0 || graph[parent][value] == 0) {
                    q.offer(value);
                    graph[parent][value] = 1;
                    graph[end][value] = 1;
                }
            }
        }
    }

    static void resultPrint() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
