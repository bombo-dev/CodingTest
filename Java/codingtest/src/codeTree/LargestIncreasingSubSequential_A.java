package codeTree;

import java.io.*;
public class LargestIncreasingSubSequential_A {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String [] value = br.readLine().split(" ");
        int[] arr = new int[N + 1];

        int[] dp = new int[N + 1];
        for(int i = 1; i <= value.length; i++){
            arr[i] = Integer.parseInt(value[i - 1]);
        }

        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            int max = 0;
            for(int j = 1; j < i; j++){
                if(arr[i] >= arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        for(int i = 1; i <= N; i++){
            System.out.println(i + "번 째 인덱스 dp : " + dp[i]);
        }
    }
}
