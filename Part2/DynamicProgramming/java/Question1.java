import java.io.*;
import java.util.*;

public class Question1 {
    public static int[] dp = new int[30001];

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        for(int i = 2; i <= x; i++){
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            } else if(i % 3 == 0){
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            } else if(i % 5 == 0){
                dp[i] = Math.min(dp[i - 1], dp[i / 5]) + 1;
            } else{
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.print(dp[x]);
    }
}
