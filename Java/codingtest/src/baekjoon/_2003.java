package baekjoon;

import java.io.*;
import java.util.*;

public class _2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        int b = 0;
        int count = 0;
        int total = 0;
        while(b < N || a < N){
            while(b < N){
                total += arr[b];
                b++;
                if(total > M)
                    break;
                else if(total == M)
                    count++;
            }

            while(b > a && a < N) {
                total -= arr[a];
                a++;
                if(total < M)
                    break;
                else if(total == M)
                    count++;
            }
        }

        System.out.print(count);
    }
}
