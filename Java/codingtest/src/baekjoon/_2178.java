package baekjoon;

import java.io.*;
import java.util.*;

class Node {
    int row;
    int col;

    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class _2178 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initValue = br.readLine().split(" ");
        int row = Integer.parseInt(initValue[0]);
        int col = Integer.parseInt(initValue[1]);

        int[][] graph = new int[row + 2][col + 2];
        int[][] graph_value = new int[row + 2][col + 2];
        boolean[][] visited = new boolean[row + 2][col + 2];

        for(int i = 0; i < graph_value.length; i++){
            for(int j = 0; j < graph_value[i].length; j++){
                Arrays.fill(graph_value[i], (int)1e9);
            }
        }

        for(int i = 0; i < row; i++){
            String graphValue = br.readLine();
            for(int j = 0; j < graphValue.length(); j++){
                graph[i + 1][j + 1] = (int)(graphValue.charAt(j) - '0');
            }
        }

        BFS(graph, graph_value, visited);
        System.out.print(graph_value[row][col]);
    }

    public static void BFS(int[][] graph, int[][] graph_value, boolean[][] visited){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(1, 1));
        graph_value[1][1] = 1;

        while(!dq.isEmpty()){
            Node node = dq.poll();
            int row = node.row;
            int col = node.col;
            if(visited[row][col])
                continue;

            visited[row][col] = true;
            for(int i = 0; i < 4; i++){
                if(visited[row + dx[i]][col + dy[i]] == false && graph[row + dx[i]][col + dy[i]] != 0){
                    dq.offer(new Node(row + dx[i], col + dy[i]));
                    graph_value[row + dx[i]][col + dy[i]] = Math.min(graph_value[row][col] + 1, graph_value[row + dx[i]][col + dy[i]]);
                }
            }
        }
    }
}
