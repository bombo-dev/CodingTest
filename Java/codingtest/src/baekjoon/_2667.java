package baekjoon;

import java.io.*;
import java.util.*;
public class _2667 {
    public static int houseNumber = 1;
    public static int houseCount = 1;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 2][N + 2];

        ArrayList<Integer> houseList = new ArrayList<>();
        boolean[][] visited = new boolean[N + 2][N + 2];

        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i + 1][j + 1] = (int) (value.charAt(j) - '0');
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    DFS(graph, visited, i, j);
                    houseList.add(houseCount);
                    houseNumber++;
                    houseCount = 1;
                }
            }
        }

        Collections.sort(houseList);
        System.out.println(houseList.size());
        for (int val : houseList) {
            System.out.println(val);
        }
    }

    public static void DFS(int[][] graph, boolean[][] visited, int row, int col) {
        graph[row][col] = houseNumber;
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            if (graph[row + dx[i]][col + dy[i]] != 0 && !visited[row + dx[i]][col + dy[i]]) {
                houseCount++;
                DFS(graph, visited, row + dx[i], col + dy[i]);
            }
        }
    }
}
