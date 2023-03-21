package baekjoon;

import java.io.*;
import java.util.*;
public class _1926 {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int sum = 0;
    static int count = 0;
    static int row = 0;
    static int col = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        int[][] graph = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String[] value = br.readLine().split(" ");
            for(int j = 0; j < value.length; j++){
                graph[i][j] = Integer.parseInt(value[j]);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    count++;
                    BFS(graph, visited, i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(sum);
    }

    public static void BFS(int[][] graph, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int total = 0;
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int px = position[0];
            int py = position[1];
            total++;

            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx > row - 1 || ny < 0 || ny > col - 1 || graph[nx][ny] == 0 || visited[nx][ny])
                    continue;

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        sum = Math.max(sum, total);
    }
}
