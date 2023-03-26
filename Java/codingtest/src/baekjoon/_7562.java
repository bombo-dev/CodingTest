package baekjoon;

import java.io.*;
import java.util.*;

public class _7562 {

    static int[][] graph;
    static boolean[][] visited;
    static int[] object = new int[2];
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // init
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            visited = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x][y] = true;
            st = new StringTokenizer(br.readLine(), " ");
            object[0] = Integer.parseInt(st.nextToken());
            object[1] = Integer.parseInt(st.nextToken());

            // bfs 실행, 실행 전 x, y 와 목표 값 같은지 확인
            if(x != object[0] || y != object[1]) {
                BFS(x, y);
            }
            System.out.println(graph[object[0]][object[1]]);
        }
    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 8; i++) {

                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[px][py] + 1;
                    q.offer(new int[]{nx, ny});
                    if(nx == object[0] && ny == object[1])
                        return;
                }
            }
        }
    }
}
