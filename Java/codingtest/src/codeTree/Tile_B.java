package codeTree;

import java.util.Scanner;

public class Tile_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[(int)1e9];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 2] * 2 + dp[i - 1];
        }

        for(int i = 0; i <= N; i++){
            System.out.println(i + " : " + dp[i]);
        }
    }
}
