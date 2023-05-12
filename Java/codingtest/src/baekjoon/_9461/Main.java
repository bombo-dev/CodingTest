package baekjoon._9461;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i <= 100; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }
    }

    static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        while(T--> 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}
