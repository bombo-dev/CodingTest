package codeTree;

import java.io.*;

public class StringMatching_A {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String AString = br.readLine();
        String BString = br.readLine();

        int[][] dp = new int[AString.length()][BString.length()];

        if(AString.charAt(0) == BString.charAt(0))
            dp[0][0] = 1;
        else
            dp[0][0] = 0;

        int columnValue = 0;
        int rowValue = 0;
        for(int i = 1; i < dp.length; i++){
            if(AString.charAt(0) == BString.charAt(i))
                columnValue = 1;

            if(BString.charAt(0) == AString.charAt(i))
                rowValue = 1;
            dp[0][i] = Math.max(dp[0][i - 1], columnValue);
            dp[i][0] = Math.max(dp[i - 1][0], rowValue);
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(AString.charAt(i) == BString.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print("dp[" + i + "][" + j + "] : " + dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
