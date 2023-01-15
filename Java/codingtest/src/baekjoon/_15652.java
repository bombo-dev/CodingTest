package baekjoon;

import java.io.*;
import java.util.*;
public class _15652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int [] arr = new int[r];

        DFS(n, r,  1, 0, arr);
    }

    public static void DFS(int n, int r, int start, int depth, int[] arr){
        if(depth == r){
            print(arr, arr.length);
            return;
        }

        for(int i = start; i <= n; i++){
            arr[depth] = i;
            DFS(n, r, arr[depth],depth + 1, arr);
        }
    }

    public static void print(int[] arr, int length){
        for(int i = 0; i < length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
