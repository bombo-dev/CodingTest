package baekjoon;

import java.util.*;
import java.io.*;

public class _5427 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int[][] graph = new int[row][col];
            int result = Integer.MAX_VALUE;

            boolean[][] fire_visited = new boolean[row][col];
            boolean[][] person_visited = new boolean[row][col];

            Queue<int[]> fireQ = new LinkedList<>();
            Queue<int[]> personQ = new LinkedList<>();

            // 값 초기화
            for(int j = 0; j < row; j++) {
                String value = br.readLine();
                for(int k = 0; k < value.length(); k++) {
                    char ch = value.charAt(k);
                    if(ch == '#') {
                        graph[j][k] = -1;
                    } else if (ch == '*') {
                        fireQ.offer(new int[]{j, k});
                        fire_visited[j][k] = true;
                    } else if (ch == '@') {
                        personQ.offer(new int[]{j, k});
                        person_visited[j][k] = true;
                    }
                }
            }
            // 불 부터 계산
            if(fireQ.size() != 0) {
                fire_BFS(fireQ, graph, row, col, fire_visited);
            }

            // 사람 계산 가고자 하는 곳이 이동 거리보다 작다면 고
            result = person_BFS(personQ, graph, row, col, result, person_visited);

            if(result == Integer.MAX_VALUE){
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result + 1);
            }
        }
    }

    public static void fire_BFS(Queue<int[]> q, int[][] graph, int row, int col, boolean[][] visited) {

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx >= 0 && nx < row && ny >= 0 && ny < col && graph[nx][ny] != -1 && !visited[nx][ny]) {
                    // 첫 시작점이거나, 다음 이동이 전의 이동보다 작다면 업데이트 이동거리간의 크기 비교 필수
                        q.offer(new int[]{nx, ny});
                        graph[nx][ny] = graph[px][py] + 1;
                        visited[nx][ny] = true;
                }
            }
        }
    }

    public static int person_BFS(Queue<int[]> q, int[][] graph, int row, int col, int min, boolean[][] visited) {
        int[] peek = q.peek();
        graph[peek[0]][peek[1]] = 0;

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx >= 0 && nx < row && ny >= 0 && ny < col && graph[nx][ny] != -1 && !visited[nx][ny]) {
                    if(graph[nx][ny] == 0 || graph[px][py] + 1 < graph[nx][ny] ) {
                        q.offer(new int[]{nx, ny});
                        graph[nx][ny] = graph[px][py] + 1;
                        visited[nx][ny] = true;

                        // 탈출 입구 일 때 연산
                        if(nx == 0 || nx == row - 1 || ny == 0 || ny == col - 1) {
                            min = Math.min(min, graph[nx][ny]);
                        }
                    }
                }
            }
        }
        return min;
    }
}
