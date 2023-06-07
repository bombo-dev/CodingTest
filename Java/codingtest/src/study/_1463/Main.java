package study._1463;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.print(0);
            return;
        }

        if (n <= 3) {
            System.out.print(1);
            return;
        }

        dp = new int[n * 3 + 1];
        Arrays.fill(dp, (int)1e9);
        dp[1] = 0;
        int result = solve(n);
        System.out.print(result);
    }

    static int solve(int n) {
        for (int i = 1; i <= n; i++) {
            dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
            dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
        }
        return dp[n];
    }
}
