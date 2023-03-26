package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 네모를 하나의 좌표로 봐야했다. 색칠된 네모 1 == [1, 0] 좌표
 * 직사각형을 만들라고 했을 때, 직사각형을 네모 그 자체로 볼 것인지 좌표로 볼 것 인지에 대한 판단이 필요하다.
 * 너무 꼬아서 생각하지 말자.
 */

public class _2583 {
    static int row;
    static int col;
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count = 0;

    // row, col - y
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[row][col];

        // 3, 0, 1, 4
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(),  " ");
            int x1 = Integer.parseInt(st.nextToken()); // 0
            int y1 = Integer.parseInt(st.nextToken()); // 2
            int x2 = Integer.parseInt(st.nextToken()); // 4
            int y2 = Integer.parseInt(st.nextToken()); // 4

            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    graph[y][x] = 1;
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(graph[i][j] == 0) {
                    count = 0;
                    DFS(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static void DFS(int x, int y) {
        graph[x][y] = 1;
        count++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < row && ny >= 0 && ny < col && graph[nx][ny] == 0) {
                DFS(nx, ny);
            }
        }
    }
}
