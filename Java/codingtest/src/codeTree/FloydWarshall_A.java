package codeTree;

import java.io.*;
import java.util.*;

public class FloydWarshall_A {
    public static int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];

        int edge = Integer.parseInt(br.readLine());

        for(int i = 0; i < edge; i++){
            String[] initGraph = br.readLine().split(" ");
            int start = Integer.parseInt(initGraph[0]);
            int end = Integer.parseInt(initGraph[1]);
            int distance = Integer.parseInt(initGraph[2]);

            graph[start][end] = distance;
        }

        int[][] d = new int[N + 1][N + 1];
        for(int i = 0; i < d.length; i++){
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i != j && graph[i][j] == 0)
                    d[i][j] = INF;
                else
                    d[i][j] = graph[i][j];
            }
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }
}
