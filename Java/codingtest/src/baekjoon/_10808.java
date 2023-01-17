package baekjoon;

import java.io.IOException;
import java.io.*;
public class _10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int[] alpha = new int[26];
        for(char val : arr){
            alpha[(int)val - 'a'] += 1;
        }

        for(int val : alpha)
            System.out.print(val + " ");
    }
}
