package baekjoon;

import java.io.*;



/**
 * <p>A(n) = A(n-1) + A(n-2) + A(n-3)</p>
 * <p>A(n-1) : A(n-1)의 뒤에 + 1</p>
 * <p>A(n-2) : A(n-2)의 뒤에 + 2</p>
 * <p>A(n-3) : A(n-3)의 뒤에 + 3</p>
 * <p>이 전체를 모두 다하면 A(n)이 나온다.</p>
 */
public class _9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j = 4; j <= n; j++) {
                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }
            System.out.println(dp[n]);
        }
    }
}
