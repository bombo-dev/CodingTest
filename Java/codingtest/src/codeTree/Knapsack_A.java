package codeTree;

import java.io.*;
import java.util.Arrays;

class Jewel {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
public class Knapsack_A {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Jewel[] arr = new Jewel[N + 1];
        for(int i = 1; i <= N; i++){
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            arr[i] = new Jewel(weight, value);
        }

        int dpSize = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][dpSize + 1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.min(dpSize, max + arr[i].weight);
            for(int j = 0; j <= max; j++){
                if(j - arr[i].weight >= 0 && dp[i - 1][j - arr[i].weight] != -1)
                    dp[i][j] = Math.max(dp[i - 1][j - arr[i].weight] + arr[i].value, dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(i + "번 째 시작 : ");
            for(int j = 0; j <= dpSize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
