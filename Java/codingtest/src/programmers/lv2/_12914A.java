package programmers.lv2;


/**
 * i >= 1 이고,
 * n == i, r == 0 일 때,
 * n--, r++ 를 진행하면서 n == r 이 될 때 까지의 경우의 수는
 * i 번 째 피보나치 수와 동일하다.
 */
public class _12914A {
    static long[] dp = new long[2001];

    public long solution(int n) {
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
