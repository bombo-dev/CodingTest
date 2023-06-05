package study._2178;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        String[] init = br.readLine().split(" ");
        n = stoi(init[0]);
        m = stoi(init[1]);

        visited = new boolean[n][m];
        graph = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] value = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                graph[i][j] = stoi(value[j]);
            }
        }
    }

    static void solve() {
        bfs();
        System.out.print(graph[n - 1][m - 1]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || graph[nx][ny] == 0)
                    continue;

                graph[nx][ny] = graph[px][py] + 1;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}