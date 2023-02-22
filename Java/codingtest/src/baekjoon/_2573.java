package baekjoon;

import java.io.*;
import java.util.*;

public class _2573 {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];


        for(int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        boolean notYet = true;
        int step = 0;
        int count = 0;
        while(notYet) {
            step++;
            notYet = false;
            visited = new boolean[N][M];
            check = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j] && graph[i][j] == 0)
                        BFS(i, j);
                }
            }

            count = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!check[i][j] && graph[i][j] != 0) {
                        count = checkBFS(i, j, ++count);
                        notYet = true;
                    }
                }
            }

            if(count > 1)
                break;
        }

        if(count > 1){
            System.out.println(step);
        } else {
            System.out.println(0);
        }
    }

    public static void BFS(int x, int y){
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

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
                    continue;

                if(graph[nx][ny] == 0) {
                    dq.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                } else {
                    graph[nx][ny] -= 1;
                    if(graph[nx][ny] == 0)
                        visited[nx][ny] = true;
                }
            }
        }
    }

    public static int checkBFS(int x, int y, int count){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{x, y});
        check[x][y] = true;

        while(!dq.isEmpty()){
            int[] position = dq.poll();
            int now_x = position[0];
            int now_y = position[1];

            for(int i = 0; i < 4; i++){
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || graph[nx][ny] == 0 || check[nx][ny])
                    continue;

                dq.offer(new int[]{nx, ny});
                check[nx][ny] = true;
            }
        }

        return count;
    }

    public static void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
