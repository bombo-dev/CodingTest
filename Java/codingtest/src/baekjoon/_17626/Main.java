package baekjoon._17626;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp = new int[50001];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
    }

    static void solve() {
        for(int i = 2; i <= 50000; i++) {
            dp[i] = dp[i - 1] + 1;
            for(int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.print(dp[N]);
    }
}
