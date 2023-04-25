package baekjoon._9465;

import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static int N;
    static int[][] arr;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        T = stoi(br.readLine());
        for(int i = 0; i < T; i++) {
            play();
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }

    static void play() throws IOException {
        init();
        dp();
    }

    private static void init() throws IOException {
        N = stoi(br.readLine());
        arr = new int[2][N];
        dp = new int[2][N];

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }
    }

    private static void dp() {

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        if(N >= 2) {
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 2] + arr[0][i], dp[1][i - 1] + arr[0][i]);
                dp[1][i] = Math.max(dp[0][i - 2] + arr[1][i], dp[0][i - 1] + arr[1][i]);
            }
        }
        System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
    }
}
