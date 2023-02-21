package baekjoon;

import java.io.*;
import java.util.*;

public class _7569 {

    static int col, row, height;
    static int zero = 0;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();

    static int lastCount =0;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        int[][][] basket = new int[height][row][col];
        boolean[][][] visited = new boolean[height][row][col];
        int[][][] count = new int[height][row][col];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < row; j++){
                String[] tomato = br.readLine().split(" ");
                for(int k = 0; k < tomato.length; k++){
                    int value = Character.getNumericValue(tomato[k].charAt(0));
                    if(value == 1) {
                        dq.offer(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                    else if (value == 0)
                        zero++;

                    basket[i][j][k] = value;
                }
            }
        }

        if(zero == 0) {
            System.out.print(0);
            return;
        }

        BFS(basket, visited, count);

        if(zero != 0){
            System.out.print(-1);
        } else {
            System.out.print(lastCount);
        }

    }

    public static void BFS(int[][][] basket, boolean[][][] visited, int[][][] count){

        while(!dq.isEmpty()){
            int[] now = dq.poll();
            int h = now[0];
            int x = now[1];
            int y = now[2];

            lastCount = Math.max(lastCount, count[h][x][y]);

            for(int i = 0; i < 6; i++){
                int nh = h + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < row && ny >= 0 && ny < col && nh >= 0 && nh < height && basket[nh][nx][ny] == 0 && !visited[nh][nx][ny]) {
                    dq.offer(new int[]{nh, nx, ny});
                    visited[nh][nx][ny] = true;
                    basket[nh][nx][ny] = 1;
                    count[nh][nx][ny] = count[h][x][y] + 1;
                    zero--;
                }
            }
        }
    }
}
