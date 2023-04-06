package baekjoon;

import java.io.*;
import java.util.*;
public class _15656 {
    static int N, M;
    static StringTokenizer st;
    static StringBuilder sb;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static int[] arr;

    // 순서가 있는 중복 순열 N^M
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sb = new StringBuilder();

        backTracking(0, M);
        System.out.println(sb.toString());
    }

    static void backTracking(int depth, int findDepth){
        if(depth == findDepth){
            for(int val : dq){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            dq.offer(arr[i]);
            backTracking(depth + 1, findDepth);
            dq.removeLast();
        }
    }
}
