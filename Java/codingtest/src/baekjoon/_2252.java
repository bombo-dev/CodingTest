package baekjoon;

import java.io.*;
import java.util.*;

public class _2252 {
    static int N;
    static int M;
    static int[] inDegree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        inDegree = new int[N + 1];

        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;
        }

        for(int i = 0; i < N; i++){
            int searchIndex = 0;
            for(int j = 1; j <= N; j++){
                if(inDegree[j] == 0 && !visited[j]) {
                    searchIndex = j;
                    sb.append(searchIndex + " ");
                    visited[searchIndex] = true;
                    break;
                }
            }

            for(int direction : graph.get(searchIndex)){
                inDegree[direction]--;
            }
        }

        System.out.print(sb);
    }
}
