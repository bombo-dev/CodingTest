package baekjoon._2623;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // 가수 수
    static int M; // PD 수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] inDegree;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        init();
        topologySort();
        if(isCycle()) {
            System.out.print(0);
        } else {
            System.out.print(sb);
        }
    }
    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        inDegree = new int[N + 1];

        link();
    }

    static void link() throws IOException {
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int singer = stoi(st.nextToken());
            int preSinger = stoi(st.nextToken());
            for(int j = 0; j < singer - 1; j++) {
                int postSinger = stoi(st.nextToken());
                graph.get(preSinger).add(postSinger);
                inDegree[postSinger]++;
                preSinger = postSinger;
            }
        }
    }

    static void topologySort() {
        firstFill();
        while(!q.isEmpty()) {
            int index = q.poll();
            sb.append(index).append("\n");

            for(int end : graph.get(index)) {
                inDegree[end]--;
                if(inDegree[end] == 0) {
                    q.offer(end);
                    visited[end] = true;
                }
            }
        }
    }

    static void firstFill() {
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                visited[i] = true;
            }
        }
    }

    static boolean isCycle() {
        for(int i = 1; i <= N; i++) {
            if(!visited[i])
                return true;
        }
        return false;
    }

    static void printInit() {
        for(int i = 1; i <= N; i++) {
            System.out.print(inDegree[i] + " ");
        }
        System.out.println();

        for(int i = 1; i <= N; i++) {
            System.out.println(i + "번");
            System.out.println("======");
            for(int end : graph.get(i)) {
                System.out.println(i + "->" + end);
            }
            System.out.println("======");
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
