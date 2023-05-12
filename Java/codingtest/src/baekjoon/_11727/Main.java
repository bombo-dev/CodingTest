package baekjoon._11727;

import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        if(N == 1)
            System.out.print(1);
        else if(N == 2)
            System.out.print(3);
        else {
            long[] dp = new long[N + 1];
            dp[1] = 1;
            dp[2] = 3;
            for(int i = 3; i <= N; i++) {
                dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
            }
            System.out.print(dp[N]);
        }
    }
}
