package codingbook.dynamicProgramming;

import java.io.*;
import java.util.*;

public class Question3 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 2] * 2) + dp[i - 1];
        }
        System.out.print(dp[n] % 796796);
    }
}
