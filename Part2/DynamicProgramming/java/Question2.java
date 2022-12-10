import java.io.*;
import java.util.*;
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[101];
        int[] food = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < s.length; i++){
            food[i + 1] = Integer.parseInt(s[i]);
        }
        dp[1] = food[1];
        dp[2] = Math.max(food[1], food[2]);
        for(int i = 3; i < n + 1; i++){
            dp[i] = Math.max(dp[i - 2] + food[i], food[i]);
        }

        System.out.print(dp[n]);
    }
}
