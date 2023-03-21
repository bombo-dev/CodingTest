package baekjoon;

import java.io.*;
import java.util.*;

public class _7576 {
    static int col;
    static int row;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String[] value = br.readLine().split(" ");
            for(int j = 0; j < value.length; j++){
                graph[i][j] = Integer.parseInt(value[j]);
                if(graph[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }

        BFS();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(graph[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }

        if(max == 0){
            System.out.print(max);
        } else {
            System.out.print(max - 1);
        }

    }

    public static void BFS() {

        while(!q.isEmpty()){
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];
            visited[px][py] = true;

            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(range(nx, ny))
                    continue;
                if(graph[nx][ny] == 1)
                    continue;
                q.offer(new int[]{nx, ny});
                graph[nx][ny] = graph[px][py] + 1;
                visited[nx][ny] = true;
                max = Math.max(graph[nx][ny], max);
            }
        }
    }

    public static boolean range(int x, int y){
        return x < 0 || x >= row || y < 0 || y >= col || visited[x][y] || graph[x][y] == -1;
    }
}
