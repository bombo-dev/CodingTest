package baekjoon;

import java.io.*;
import java.util.*;


public class _10026 {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int[][] graph;
    static boolean[][] n_visited;
    static boolean[][] p_visited;
    static int normal = 0;
    static int color = 0;
    static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        n_visited = new boolean[N][N];
        p_visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String value = br.readLine();
            for(int j = 0; j < N; j++){
                if(value.charAt(j) == 'R') {
                    graph[i][j] = 1;
                } else if(value.charAt(j) == 'G') {
                    graph[i][j] = 2;
                } else if(value.charAt(j) == 'B') {
                    graph[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!n_visited[i][j]) {
                    BFS(i, j);
                    normal++;
                }
                if(!p_visited[i][j]) {
                    p_BFS(i, j);
                    color++;
                }
            }
        }

        System.out.print(normal + " " + color);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        n_visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(isRange(nx, ny) && graph[px][py] == graph[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    n_visited[nx][ny] = true;
                }
            }
        }
    }

    public static void p_BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        p_visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(p_isRange(nx, ny)) {
                    if(graph[px][py] == graph[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        p_visited[nx][ny] = true;
                    } else {
                        if((graph[px][py] == 1 && graph[nx][ny] == 2) || (graph[px][py] == 2 && graph[nx][ny] == 1)) {
                            q.offer(new int[]{nx, ny});
                            p_visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !n_visited[x][y];
    }

    public static boolean p_isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !p_visited[x][y];
    }
}
