package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25501 {
    public static int recursionCount = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            recursionCount = 0;
            String s = br.readLine();
            int palindrome = checkPalindrome(s, 0, s.length() - 1);
            System.out.println(palindrome + " " + recursionCount);
        }
    }

    public static int checkPalindrome(String s, int l, int r){
        recursionCount++;
        if(l >= r)
            return 1;
        else if(s.charAt(l) != s.charAt(r))
            return 0;
        else return checkPalindrome(s, l + 1, r - 1);
    }
}
