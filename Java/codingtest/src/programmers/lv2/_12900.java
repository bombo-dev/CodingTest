package programmers.lv2;

public class _12900 {
    public int solution(int n) {
        int[] dp = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        int answer = dp[n];
        return answer;
    }
}
