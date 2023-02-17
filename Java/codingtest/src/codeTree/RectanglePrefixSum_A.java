package codeTree;

import java.io.*;

public class RectanglePrefixSum_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rectangle = new int[N][N];
        int[][] dp = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] value = br.readLine().split("");
            for(int j = 0; j < N; j++){
                rectangle[i][j] = Integer.parseInt(value[j]);
            }
        }
        dp[0][0] = rectangle[0][0];

        for(int i = 1; i < N; i++){
            dp[i][0] = dp[i - 1][0] + rectangle[i][0];
            dp[0][i] = dp[0][i - 1] + rectangle[0][i];
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){
                dp[i][j] = Math.max(dp[i - 1][j] + rectangle[i][j], dp[i][j - 1] + rectangle[i][j]);
            }
        }


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
