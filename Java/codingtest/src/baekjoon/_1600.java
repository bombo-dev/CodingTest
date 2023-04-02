package baekjoon;

import java.io.*;
import java.util.*;

class Monkey {
    int x;
    int y;
    int preKnight;
    int time;

    public Monkey(int x, int y, int preKnight, int time) {
        this.x = x;
        this.y = y;
        this.preKnight = preKnight;
        this.time = time;
    }
}

// 왜 안되는지 모르겠음 ㅠ
public class _1600 {
    static int K;
    static int row;
    static int col;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] moveKnightX = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] moveKnightY = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        graph = new int[row][col];
        visited = new boolean[K + 1][row][col]; // 0은 아예 Knight 로 이동안한 경우

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                int val = Integer.parseInt(st.nextToken());
                graph[i][j] = val;
            }
        }

        BFS();

        if (result == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }
    }

    public static void BFS() {
        Queue<Monkey> q = new ArrayDeque<>();
        q.offer(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Monkey m = q.poll();
            int px = m.x;
            int py = m.y;
            int preKnight = m.preKnight;
            int time = m.time;

            if (px == row - 1 && py == col - 1) {
                result = time;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col || visited[preKnight][nx][ny] || graph[nx][ny] == 1)
                    continue;

                q.offer(new Monkey(nx, ny, preKnight, time + 1));
                visited[preKnight][nx][ny] = true;
            }

            if (preKnight < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = px + moveKnightX[i];
                    int ny = py + moveKnightY[i];

                    if (nx < 0 || nx >= row || ny < 0 || ny >= col || visited[preKnight][nx][ny] || graph[nx][ny] == 1)
                        continue;

                    q.offer(new Monkey(nx, ny, preKnight + 1, time + 1));
                    visited[preKnight + 1][nx][ny] = true;
                }
            }
        }
    }
}
