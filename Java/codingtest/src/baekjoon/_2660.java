package baekjoon;

import java.io.*;
import java.util.*;
public class _2660 {
    static int[][] graph;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for(int i = 0; i < N + 1; i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }


        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1)
                break;

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for(int k = 1; k < N + 1; k++){
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < N + 1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        int[] maxValue = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            int max = 0;
            for(int j = 1; j < N + 1; j++) {
                max = Math.max(max, graph[i][j]);
            }
            min = Math.min(min, max);
            maxValue[i] = max;
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + 1; i++) {
            if(maxValue[i] == min) {
                count++;
                sb.append(i).append(" ");
            }
        }

        System.out.println(min + " " + count);
        System.out.print(sb);
    }
}
