package baekjoon;

import java.io.*;
import java.util.*;
public class _11404 {

    static int N;
    static int M;
    static int[][] graph;

    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];

        for(int i = 0; i < N + 1; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < N + 1; i++){
            graph[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        for(int k = 1; k < N + 1; k++){
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < N + 1; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(graph[i][j] == INF)
                    graph[i][j] = 0;
            }
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
