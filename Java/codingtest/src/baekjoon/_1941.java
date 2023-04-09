package baekjoon;

import java.io.*;
import java.util.*;

class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 완전 탐색
// DFS, BFS 로는 Y자 형태의 탐색을 할 수 없음.
public class _1941 {
    static char[] position = new char[25];
    static int findDepth = 7;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Pos[] posArr = new Pos[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            String value = br.readLine();
            for(int j = 0; j < 5; j++){
                position[i * 5 + j] = value.charAt(j);
            }
        }

        backTracking(0, 0, 0, 0, 0);

        System.out.print(count);
    }

    static void backTracking(int depth, int S, int Y, int target, int start) {

        if(depth == findDepth && S >= 4) {
            int[][] value = new int[5][5];
            for(Pos p : posArr) {
                value[p.x][p.y] = 1;
            }

            if(isSeven(value)){
                count++;
            }
            return;
        }

        if(Y > 3)
            return;

        if(target >= 7)
            return;


        for(int i = start; i < 25; i++){
            if(position[i] == 'Y') {
                posArr[target] = new Pos(i / 5 , i % 5);
                backTracking(depth + 1, S, Y + 1, target + 1, i + 1);
            } else {
                posArr[target] = new Pos(i / 5, i % 5);
                backTracking(depth + 1, S + 1, Y, target + 1, i + 1);
            }
        }
    }

    // BFS 로 방문처리하고 첫 값만 넣어서, 개수 카운트해서도 가능
    static boolean isSeven(int[][] value){
        boolean[][] visited = new boolean[5][5];

        int cnt = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(value[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    DFS(i, j, value, visited);
                }
            }
        }

        if(cnt == 1)
            return true;
        return false;
    }

    static void DFS(int x, int y, int[][] value, boolean[][] visited) {

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if(value[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    DFS(nx, ny, value, visited);
                }
            }
        }
    }
}
