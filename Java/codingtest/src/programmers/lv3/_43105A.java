package programmers.lv3;

public class _43105A {
    static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j <= i; j++){
                if(j >= 1){
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
                    answer = Math.max(dp[i][j], answer);
                } else {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        return answer;
    }
}
