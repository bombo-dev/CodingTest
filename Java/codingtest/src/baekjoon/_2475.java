package baekjoon;

import java.io.*;
import java.util.*;
public class _2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;
        while(st.hasMoreElements()) {
            sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }

        System.out.print(sum % 10);
    }
}
