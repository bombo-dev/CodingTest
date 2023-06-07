package study._9095;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        while(T-->0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
