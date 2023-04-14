package baekjoon;

import java.io.*;
import java.util.*;

class _20166Position {
    int x;
    int y;
    String value;
    int depth;

    _20166Position(int x, int y, String value, int depth) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.depth = depth;
    }
}

public class _20166 {
    static int N;
    static int M;
    static int K;
    static char[][] board;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static Map<String, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String value = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = value.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                search(i, j);
            }
        }

        while(K-->0) {
            Long count = map.get(br.readLine());
            if(count != null){
                System.out.println(count);
            } else {
                System.out.println(0);
            }
        }
    }

    static void search(int n, int m) {
        Queue<_20166Position> q = new LinkedList<>();
        q.offer(new _20166Position(n, m, String.valueOf(board[n][m]), 0));

        while(!q.isEmpty()) {
            _20166Position position = q.poll();
            int x = position.x;
            int y = position.y;
            String value = position.value;
            int depth = position.depth;

            if(depth >= 5)
                continue;

            map.put(value, map.getOrDefault(value, 0L) + 1);

            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 대각선 환형
                // 위로 환형
                // 좌우로 환형
                if(nx < 0) {
                    nx = N - 1;
                } else if (nx >= N) {
                    nx = 0;
                }
                if(ny < 0) {
                    ny = M - 1;
                } else if (ny >= M){
                    ny = 0;
                }

                if(depth + 1 < 5) {
                    q.offer(new _20166Position(nx, ny, value + board[nx][ny], depth + 1));
                }
            }
        }
    }
}
