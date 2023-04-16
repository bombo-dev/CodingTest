package baekjoon;

import java.io.*;
import java.util.*;

// 플로이드 워셜 문제
public class _1389 {
    public static void main(String[] args) throws IOException {
        final int INF = (int)1e8;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];

        for(int i = 0; i < N + 1; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < N + 1; i++) {
            graph[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for(int k = 1; k < N + 1; k++){
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < N + 1; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 1; i < N + 1; i++) {
            int kevin = 0;
            for(int j = 1; j < N + 1; j++) {
                kevin += graph[i][j];
            }
            if(result > kevin) {
                result = kevin;
                index = i;
            }
        }

        System.out.print(index);
    }
}
