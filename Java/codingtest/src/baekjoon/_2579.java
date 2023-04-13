package baekjoon;

import java.io.*;
public class _2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        dp[0] = arr[0];
        if(N == 1){
            System.out.print(dp[0]);
            return;
        } else if(N == 2) {
            dp[1] = Math.max(arr[0] + arr[1], arr[1]);
            System.out.print(dp[1]);
            return;
        } else if(N == 3) {
            dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);
            System.out.print(dp[2]);
            return;
        } else {
            dp[1] = Math.max(arr[0] + arr[1], arr[1]);
            dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);
        }

        // 계단의 개수는 1개일 수도 있음.

        for(int i = 3; i < N; i++){
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        }

        System.out.print(dp[N - 1]);
    }
}
