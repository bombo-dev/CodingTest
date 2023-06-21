package codingbook.shortestPath;

import java.io.*;
import java.util.*;

public class Question1 {
    public static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int e = Integer.parseInt(init[1]);

        int[][] graph = new int[n + 1][n + 1];

        for(int i = 0; i < graph.length; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 1; i < graph.length; i++){
            graph[i][i] = 0;
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        String[] xk = br.readLine().split(" ");
        int x = Integer.parseInt(xk[0]);
        int k = Integer.parseInt(xk[1]);

        for(int a = 1; a < n + 1; a++){
            for(int b = 1; b < n + 1; b++){
                for(int c = 1; c < n + 1; c++){
                    graph[b][c] = Math.min(graph[b][c], graph[b][a] + graph[a][c]);
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        if(graph[1][k] + graph[k][x] >= INF){
            System.out.print(-1);
        } else{
            System.out.print(graph[1][k] + graph[k][x]);
        }
    }
}
