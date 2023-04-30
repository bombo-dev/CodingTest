package baekjoon._11726;

import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if(N <= 2) {
            System.out.print(N);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }
        System.out.print(dp[N]);
    }
}
