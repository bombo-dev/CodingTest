package codeTree;

import java.util.Scanner;

public class SelectionCoin_A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] coin = new int[N];
        int[] dp = new int[sc.nextInt() + 1];

        for(int i = 0; i < N; i++){
            coin[i] = sc.nextInt();
        }
        dp[0] = 0;

        int maxIndex = 0;
        for(int i = 1; i < dp.length; i++){
            if(maxIndex + 1 < coin.length && coin[maxIndex + 1] <= i){
                maxIndex++;
            }
            dp[i] = dp[i - 1] + 1;
            for(int j = 0; j <= maxIndex; j++){
                System.out.println(i + "번 째 maxIndex : " + maxIndex);
                if(i - coin[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1) ;
            }
        }

        for(int i = 1; i < dp.length; i++){
            System.out.println(i + "번 째 동전 : " + dp[i]);
        }
    }
}
