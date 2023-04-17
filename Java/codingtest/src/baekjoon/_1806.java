package baekjoon;

import java.io.*;
import java.util.*;
public class _1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int total = arr[start];
        while(start <= end) {
            if(min == 1){
                break;
            }

            if(total < M){
                end++;
                if(end == N){
                    break;
                }
                total += arr[end];
            } else {
                min = Math.min(min, end - start + 1);
                total -= arr[start];
                start++;
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.print(0);
        } else {
            System.out.print(min);
        }
    }
}
