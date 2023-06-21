package baekjoon;

import java.io.*;
import java.util.*;

public class _11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (a1, a2) -> a2 - a1);
        for(int i = 0; i < N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
