package baekjoon;

import java.io.*;
import java.util.*;
public class _4179 {
    static int row;
    static int col;
    static int[][] graph;
    static final int WALL = -999;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

        int max = 0;

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];

        boolean[][] fireVisited = new boolean[row][col];
        boolean[][] personVisited = new boolean[row][col];

        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> personQ = new LinkedList<>();
        Queue<int[]> result = new LinkedList<>();

        // 지훈이의 위치는
        for(int i = 0; i < row; i++) {
            String[] value = br.readLine().split("");
            for(int j = 0; j < value.length; j++) {
                if(value[j].equals("#")) {
                    graph[i][j] = WALL;
                    fireVisited[i][j] = true;
                    personVisited[i][j] = false;
                }
                else if(value[j].equals("J")) {
                    personQ.offer(new int[]{i, j});
                    personVisited[i][j] = true;
                }
                else if(value[j].equals("F")) {
                    fireQ.offer(new int[]{i, j});
                    fireVisited[i][j] = true;
                } else if(i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (value[j].equals(".")) {
                        result.offer(new int[]{i, j});
                    }
                }
            }
        }

        fireBFS(fireQ, fireVisited);
        personBFS(personQ, personVisited);

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        while(!result.isEmpty()) {
            int[] exit = result.poll();
            int x = exit[0];
            int y = exit[1];
            max = Math.max(max, graph[x][y] + 1);
        }

        System.out.print(max);
    }

    // 불 BFS
    public static void fireBFS(Queue<int[]> q, boolean[][] visited){

        while(!q.isEmpty()){
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(isRange(nx, ny, visited)) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[px][py] + 1;
                }
            }
        }
    }

    // 사람 BFS
    public static void personBFS(Queue<int[]> q, boolean[][] visited){

        int [] init = q.peek();
        graph[init[0]][init[1]] = 0;

        while(!q.isEmpty()){
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];


            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(isRange(nx, ny, visited)) {
                    if(graph[nx][ny] > graph[px][py] + 1) {
                        graph[nx][ny] = graph[px][py] + 1;
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    } else {
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y, boolean[][] visited){
        if(x >= 0 && x < row && y >= 0 && y < col && !visited[x][y] && graph[x][y] != -999)
            return true;
        return false;
    }
}
