package baekjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class _2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dp = new String[N + 1];
        dp[0] = "1";
        dp[1] = "1";

        for(int i = 2; i < N + 1; i++) {
            BigInteger big = new BigInteger(dp[i - 1]);
            BigInteger result = big.multiply(new BigInteger(String.valueOf(i)));
            dp[i] = result.toString();
        }

        BigInteger numerator = new BigInteger(dp[N]);
        BigInteger denominator = new BigInteger(dp[N - M]).multiply(new BigInteger(dp[M]));

        BigInteger result = numerator.divide(denominator);

        System.out.print(result);
    }
}
