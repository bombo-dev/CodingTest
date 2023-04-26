package baekjoon._11050;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        calc();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        fillDp();
    }

    static void fillDp() {
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] * i;
        }
    }

    static void calc() {
        int result = dp[N] / (dp[N - K] * dp[K]);
        System.out.print(result);
    }
}
