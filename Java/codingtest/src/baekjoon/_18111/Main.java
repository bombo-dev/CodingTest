package baekjoon._18111;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] game;
    static int N; // 세로
    static int M; // 가로
    static int B; // 블럭 개수
    static int totalTime = 0;
    static int resultTime = Integer.MAX_VALUE;
    static int resultMax = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.print(resultTime + " " + resultMax);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        B = stoi(st.nextToken());

        game = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                game[i][j] = stoi(st.nextToken());
                max = Math.max(max, game[i][j]);
            }
        }
        resultMax = max;
    }

    static void solve() {
        boolean isPlaying = true;
        while(isPlaying) {

            int totalBlock = 0; // 채워야 할 블럭의 개수
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    totalBlock += (max - game[i][j]);
                }
            }

            if(max < 0)
                break;

            // 채워야 할 블럭의 개수가 충분한 경우, 일단 채워보고 최소 값 갱신, 이후 제거해보고 최소 값 갱신
            if(totalBlock <= B) {
                fillBoard();
                removeBoard();
            } else { // 채워야 할 블럭의 개수가 부족하다. 그럼 무조건 제거해야 함.
                removeBoard();
            }
        }
    }

    static void removeBoard() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(game[i][j] == max) {
                    totalTime += 2;
                    B += 1;
                    game[i][j] -= 1;
                }
            }
        }
        max -= 1;
    }

    static void fillBoard() {
        int fill = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(game[i][j] != max) {
                    fill += max - game[i][j];
                }
            }
        }

        if(totalTime + fill < resultTime) {
            resultTime = totalTime + fill;
            resultMax = max;
        }

    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
