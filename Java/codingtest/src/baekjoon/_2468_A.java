package baekjoon;

import java.io.*;
import java.util.*;

public class _2468_A {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];
        boolean[][] BFS_visited = new boolean[N + 1][N + 1];
        boolean[][] DFS_visited = new boolean[N + 1][N + 1];
        int max = 0;

        for(int i = 0 ; i < N; i++){
            String[] value = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                graph[i + 1][j + 1] = Integer.parseInt(value[j]);
                max = Math.max(max, Integer.parseInt(value[j]));
            }
        }



        for(int k = 0; k <= max; k++){
            initVisited(BFS_visited, DFS_visited);
            BFS(graph, BFS_visited, DFS_visited, k);
            int count = 0;
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(DFS(DFS_visited, i, j))
                        count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        System.out.print(maxCount);
    }

    public static void BFS(int[][] graph, boolean[][] BFS_visited, boolean[][] DFS_visited, int height){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{1, 1});

        while(!dq.isEmpty()){
            int[] position = dq.poll();
            int x = position[0];
            int y = position[1];

            if(graph[x][y] <= height)
                DFS_visited[x][y] = true;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 1 || nx > N || ny < 1 || ny > N || BFS_visited[nx][ny])
                    continue;

                dq.offer(new int[]{nx, ny});
                BFS_visited[nx][ny] = true;
            }
        }
    }

    public static boolean DFS(boolean[][] visited, int x, int y){

        if(x < 1 || x > N || y < 1 || y > N || visited[x][y])
            return false;

        if(!visited[x][y]) {
            visited[x][y] = true;
            DFS(visited, x - 1, y);
            DFS(visited, x, y + 1);
            DFS(visited, x + 1, y);
            DFS(visited, x, y - 1);
            return true;
        }

        return false;
    }

    public static void initVisited(boolean[][] BFS_visited, boolean[][] DFS_visited){
        for(int i = 0; i <= N; i++){
            Arrays.fill(BFS_visited[i], false);
            Arrays.fill(DFS_visited[i], false);
        }
        for(int i = 0; i <= N; i++){
            BFS_visited[i][0] = true;
            BFS_visited[0][i] = true;
            DFS_visited[i][0] = true;
            DFS_visited[0][i] = true;
        }
    }
}
