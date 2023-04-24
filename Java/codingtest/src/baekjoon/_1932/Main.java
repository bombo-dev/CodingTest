package baekjoon._1932;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] dp;
    static int max = 0;
    public static int stoi(String value) {
        return Integer.parseInt(value);
    }
    public static void main(String[] args) throws IOException {
        N = stoi(br.readLine());
        dp = new int[N][N];
        dp[0][0] = stoi(br.readLine());
        max = dp[0][0];
        for(int i = 1; i < N; i++) {
            String[] value = br.readLine().split(" ");
            dp[i][0] = dp[i - 1][0] + stoi(value[0]);
            max = Math.max(max, dp[i][0]);
            for(int j = 1; j <= i - 1; j++) {
                int pre = stoi(value[j]);
                dp[i][j] = Math.max(dp[i - 1][j - 1] + pre, dp[i - 1][j] + pre);
                max = Math.max(max, dp[i][j]);
            }
            dp[i][i] = dp[i - 1][i - 1] + stoi(value[i]);
            max = Math.max(max, dp[i][i]);
        }

        System.out.print(max);
    }
}
