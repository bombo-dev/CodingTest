package codeTree;

import java.io.*;
import java.util.Scanner;

public class BSTCount_A {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[(int)1e9];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            int bstCount = 0;
            for(int j = 0; j <= i - 1; j++){
                bstCount += dp[j] * dp[i - j - 1];
            }
            dp[i] = bstCount;
        }

        for(int i = 0; i <= N; i++){
            System.out.println(dp[i]);
        }
    }
}
