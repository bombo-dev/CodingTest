package baekjoon;

import java.io.*;
import java.util.*;
public class _2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;

        while(end < N && start <= end) {

            if(Math.abs(arr[end] - arr[start]) == M){
                min = Math.min(min, arr[end] - arr[start]);
                break;
            }

            if(arr[end] - arr[start] < M) {
                end++;
            } else {
                min = Math.min(min, arr[end] - arr[start]);
                start++;
            }
        }

        System.out.print(min);
    }
}
