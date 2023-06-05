package study._1926;
import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static int max = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        n = stoi(input[0]);
        m = stoi(input[1]);

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] value = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                graph[i][j] = stoi(value[j]);
            }
        }
    }

    static void solve() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    count++;
                    bfs(i, j);
                }
            }
        }
    }

    static void bfs(int x, int y) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        result++;

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || graph[nx][ny] == 0)
                    continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        max = Math.max(max, result);
    }

    static void print() {
        System.out.println(count);
        System.out.println(max);
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
