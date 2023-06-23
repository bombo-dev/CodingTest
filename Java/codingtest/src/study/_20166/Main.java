package study._20166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] likedString;
    static int maxSize = 0;
    static Map<String, Integer> stringCountMap = new HashMap<>();
    static int N;
    static int M;
    static int K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        likedString = new String[K];

        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = value.charAt(j);
            }
        }

        for (int i = 0; i < K; i++) {
            likedString[i] = br.readLine();
            maxSize = Math.max(likedString[i].length(), maxSize);
        }
    }

    private static void solve() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(i, j);
            }
        }

        for (int i = 0; i < K; i++) {
            System.out.println(stringCountMap.getOrDefault(likedString[i], 0));
        }
    }

    private static void bfs(int x, int y) {
        Queue<StringComb> q = new LinkedList<>();
        q.offer(new StringComb(x, y, String.valueOf(map[x][y])));

        while (!q.isEmpty()) {
            StringComb string = q.poll();
            stringCountMap.put(string.string, stringCountMap.getOrDefault(string.string, 0) + 1);

            for (int i = 0; i < 8; i++) {
                int nx = string.x + dx[i];
                int ny = string.y + dy[i];

                if (nx < 0 && ny < 0) {
                    nx = N - 1;
                    ny = M - 1;
                } else if (nx >= N && ny < 0) {
                    nx = 0;
                    ny = M - 1;
                } else if (nx < 0 && ny >= M) {
                    nx = N - 1;
                    ny = 0;
                } else if (nx >= N && ny >= M) {
                    nx = 0;
                    ny = 0;
                } else if (nx < 0) {
                    nx = N - 1;
                } else if (nx >= N) {
                    nx = 0;
                } else if (ny < 0) {
                    ny = M - 1;
                } else if (ny >= M) {
                    ny = 0;
                }

                String nString = string.string + map[nx][ny];
                if (nString.length() <= maxSize) {
                    q.offer(new StringComb(nx, ny, nString));
                }
            }
        }
    }

    static class StringComb {
        int x;
        int y;
        String string;

        public StringComb(int x, int y, String string) {
            this.x = x;
            this.y = y;
            this.string = string;
        }
    }
}
