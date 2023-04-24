package baekjoon._1149;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] dp;

    static int stoi(String value) {
        return Integer.parseInt(value);
    }

    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        for (int i = 0; i < N; i++) {
            dp = new int[N][3];
        }
        String[] init = br.readLine().split(" ");
        dp[0][0] = stoi(init[0]);
        dp[0][1] = stoi(init[1]);
        dp[0][2] = stoi(init[2]);

        for (int i = 1; i < N; i++) {
            String[] value = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int pre = stoi(value[j]);
                if(j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1] + pre, dp[i - 1][2] + pre);
                } else if(j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0] + pre, dp[i - 1][2] + pre);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][0] + pre, dp[i - 1][1] + pre);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            result = Math.min(result, dp[N - 1][i]);
        }

        System.out.print(result);
    }
}
