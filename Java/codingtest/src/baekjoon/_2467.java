package baekjoon;

import java.io.*;
import java.util.*;
public class _2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int lastLeft = -1;
        int lastRight = N;

        while(left < right) {
            int sub = Math.abs(arr[left] + arr[right]);
            if(arr[left] + arr[right] <= 0){
                if(min > sub){
                    min = sub;
                    lastLeft = arr[left];
                    lastRight = arr[right];
                }
                left++;
            } else {
                if(min > sub){
                    min = sub;
                    lastLeft = arr[left];
                    lastRight = arr[right];
                }
                right--;
            }
        }
        System.out.print(lastLeft + " " + lastRight);
    }
}
