package baekjoon._1676;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[] dp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new String[N + 1];
    }

    static void solve() {
        if(N <= 1) {
            System.out.print(0);
            return;
        }

        dp[0] = "1";
        dp[1] = "1";

        for(int i = 2; i <= N; i++) {
            BigInteger result = new BigInteger(dp[i - 1]);
            result = result.multiply(BigInteger.valueOf(i));
            dp[i] = result.toString();
        }

        String value = dp[N];
        int result = 0;
        for(int i = value.length() - 1; i >= 0; i--) {
            if(value.charAt(i) == '0')
                result++;
            else
                break;
        }
        System.out.print(result);
    }
}
