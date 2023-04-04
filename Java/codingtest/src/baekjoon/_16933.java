package baekjoon;

import java.io.*;
import java.util.*;

class Wall2 {
    int x;
    int y;
    int time;
    int preWall;
    boolean isNight;

    Wall2(int x, int y, int time, int preWall, boolean isNight) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.preWall = preWall;
        this.isNight = isNight;
    }
}

public class _16933 {

    static int N;
    static int M;
    static int K;
    static int[][] wall;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wall = new int[N][M];
        visited = new boolean[K + 1][N][M];

        for(int i = 0; i < N; i++) {
            String value = br.readLine();
            for(int j = 0; j < M; j++){
                wall[i][j] = Character.getNumericValue(value.charAt(j));
            }
        }

        BFS();

        if(result == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }

    }

    public static void BFS() {
        Queue<Wall2> q = new LinkedList<>();
        q.offer(new Wall2(0, 0, 1, 0, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Wall2 w = q.poll();
            int px = w.x;
            int py = w.y;
            int time = w.time;
            int preWall = w.preWall;
            boolean isNight = w.isNight;

            if(px == N - 1 && py == M - 1) {
                result = Math.min(result, time);
            }

            // 밤이었으면 다시 낮이 되어야함. 밤에는 벽을 뚫을 수 없어서 가만히 있을 수 있음.
            if(isNight) {
                for(int i = 0; i < 4; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[preWall][nx][ny] && wall[nx][ny] != 1) {
                        q.offer(new Wall2(nx, ny, time + 1, preWall, false));
                        visited[preWall][nx][ny] = true;
                    }

                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && wall[nx][ny] == 1) {
                        q.offer(new Wall2(px, py, time + 1, preWall, false));
                    }
                }
            } else { // 낮이었으면 다시 밤이 되어야함. 낮에는 가만히 있을 필요가 없음.
                for(int i = 0; i < 4; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if(preWall < K) {
                            if(wall[nx][ny] == 1 && !visited[preWall + 1][nx][ny]) {
                                q.offer(new Wall2(nx, ny, time + 1, preWall + 1, true));
                                visited[preWall + 1][nx][ny] = true;
                            } else if(wall[nx][ny] == 0 && !visited[preWall][nx][ny]) {
                                q.offer(new Wall2(nx, ny, time + 1, preWall, true));
                                visited[preWall][nx][ny] = true;
                            }
                        } else {
                            if(wall[nx][ny] == 0 && !visited[preWall][nx][ny]) {
                                q.offer(new Wall2(nx, ny, time + 1, preWall, true));
                                visited[preWall][nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
