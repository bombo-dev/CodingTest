package programmers.lv2;

public class _12913 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        int max = 0;
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(k == j)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }

        for(int i = 0; i < 4; i++){
            max = Math.max(max, dp[land.length - 1][i]);
        }

        return max;
    }
}
