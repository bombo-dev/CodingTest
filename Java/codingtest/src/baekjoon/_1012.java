package baekjoon;

import java.io.*;
import java.util.*;
public class _1012 {

    static int row;
    static int col;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int total = 0;
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int[][] graph = new int[row][col];
            boolean[][] visited = new boolean[row][col];
            count = Integer.parseInt(st.nextToken());

            for(int j = 0; j < count; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            for(int x = 0; x < row; x++){
                for(int y = 0; y < col; y++){
                    if(graph[x][y] == 1 && !visited[x][y]) {
                        total++;
                        DFS(x, y, graph, visited);
                    }
                }
            }

            System.out.println(total);
        }
    }

    public static void DFS(int x, int y, int[][] graph, boolean[][] visited){

        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny, graph, visited)) {
                DFS(nx, ny, graph, visited);
            }
        }
    }

    public static boolean isRange(int x, int y, int[][] graph, boolean[][] visited) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph[0].length && !visited[x][y] && graph[x][y] == 1;
    }
}
