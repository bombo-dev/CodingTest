import java.io.*;

public class Question4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);
        int[] dp = new int[m + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i] = 10001;
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = 1; j <= m; j++){
                if(j % arr[i] == 0){
                    dp[j] = Math.min(dp[j], j /arr[i]);
                }
            }
        }
        if(dp[m] != 10001){
            System.out.print(dp[m]);
        } else{
            System.out.print(-1);
        }
    }
}
