package programmers.lv2;


// 잘못된 풀이
public class _12914 {

    static long[] dp = new long[2001];

    public long solution(int n) {

        long answer = 0;

        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            dp[i] = (dp[i - 1] * i) % 1234567;
        }

        int number = 0;
        int rounder = 0;

        if(n % 2 == 0){
            number = n / 2;
            rounder = number;
        } else {
            number = n / 2 + 1;
            rounder = number - 1;
        }

        for(int i = number, j = rounder; j >= 0; i++, j--){
            // System.out.println("현재 i : " + i + "현재 j : " + j);
            answer += combinationCount(i, j);
        }

        return answer;
    }

    public long combinationCount(int i, int j){
        if(i == j)
            return 1;
        else if(j == 1)
            return i;
        else if(j == 0)
            return 1;
        else
            return (dp[i] / (dp[j] * dp[i - j]));
    }
}
