import java.util.*;
import java.io.*;

public class FloydWarshall {
    public static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int e = Integer.parseInt(br.readLine().trim());

        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i < graph.length; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < graph.length; i++){
            graph[i][i] = 0;
        }

        for(int i = 0; i < e; i++){
            String[] value = br.readLine().split(" ");
            int index = Integer.parseInt(value[0]);
            int node = Integer.parseInt(value[1]);
            int distance = Integer.parseInt(value[2]);
            graph[index][node] = distance;
        }

        for(int k = 1; k < n + 1; k++){
            for(int i = 1; i < n + 1; i++){
                for(int j = 1; j < n + 1; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(graph[i][j] == INF){
                    System.out.print("INFINITY");
                } else{
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
