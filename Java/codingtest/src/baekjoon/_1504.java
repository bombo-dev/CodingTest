package baekjoon;

import java.io.*;
import java.util.*;
public class _1504 {

    static int V;
    static int E;
    static int[] d1;
    static int[] d2;

    static int pass1;
    static int pass2;
    static int[][] graph;
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        d1 = new int[V + 1];
        d2 = new int[V + 1];

        graph = new int[V + 1][V + 1];
        for(int i = 0; i < V + 1; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < V + 1; i++){
            graph[i][i] = 0;
        }

        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(),  " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int distance = Integer.parseInt(st2.nextToken());
            graph[a][b] = distance;
            graph[b][a] = distance;
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        pass1 = Integer.parseInt(st2.nextToken()); // 2
        pass2 = Integer.parseInt(st2.nextToken()); // 3

        for(int k = 1; k < V + 1; k++){
            for(int i = 1; i < V + 1; i++){
                for(int j = 1; j < V + 1; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int case1 = graph[1][pass1] + graph[pass1][pass2] + graph[pass2][V];
        int case2 = graph[1][pass2] + graph[pass2][pass1] + graph[pass1][V];

        if(case1 >= INF && case2 >= INF){
            System.out.println(-1);
        } else {
            System.out.println(Math.min(case1, case2));
        }
    }
}
