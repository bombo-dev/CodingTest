package baekjoon;

import java.util.*;
import java.io.*;
public class _1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] radix = new int[10];
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            int val = Character.getNumericValue(s.charAt(i));
            radix[val]++;
        }

        int calc = radix[6] + radix[9];

        if(calc % 2 == 1) {
            radix[6] = calc / 2;
            radix[9] = calc / 2 + 1;
        }
        else {
            radix[6] = calc / 2;
            radix[9] = calc / 2;
        }

        for(int i = 0; i < radix.length; i++){
            max = Math.max(radix[i], max);
        }

        System.out.print(max);
    }
}
