package baekjoon;

import java.io.*;
import java.util.*;

public class _2468 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int max = -1;

        for(int i = 0 ; i < N; i++){
            String[] value = br.readLine().split(" ");
            for(int j = 0; j < value.length; j++){
                graph[i][j] = Integer.parseInt(value[j]);
                max = Math.max(max, Integer.parseInt(value[j]));
            }
        }

        for(int i = 0; i <= max; i++){
            boolean[][] visited = new boolean[N][N];
            int count = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(!visited[j][k] && graph[j][k] > i){
                        count++;
                        BFS(graph, visited, j, k, i);
                    }
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        System.out.print(maxCount);
    }

    public static void BFS(int[][] graph, boolean[][] visited, int x, int y, int height){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!dq.isEmpty()){
            int[] position = dq.poll();
            int now_x = position[0];
            int now_y = position[1];

            for(int i = 0; i < 4; i++){
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || graph[nx][ny] <= height)
                    continue;

                dq.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}
