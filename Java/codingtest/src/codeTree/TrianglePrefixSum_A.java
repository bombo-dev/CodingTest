package codeTree;

import java.util.Scanner;

public class TrianglePrefixSum_A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N][N];
        int[][] triangle = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                triangle[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++){
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i - 1][j] + triangle[i][j], dp[i - 1][j - 1] + triangle[i][j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
