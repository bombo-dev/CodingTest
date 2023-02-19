package codeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPassword_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 8;

        for(int i = 5; i <= N; i++){
            for(int j = i - 4; j < i; j++){
                dp[i] += dp[j];
            }
        }

        for(int i = 0; i <= N; i++){
            System.out.println(i + "번 째 dp의 값 : [" + dp[i] + "]");
        }
    }
}
