package baekjoon;

import java.io.*;
import java.util.*;
public class _15657 {
    static int N, M;
    static int[] arr;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        backTracking(0, M, sb, 0);

        System.out.print(sb.toString());
    }

    static void backTracking(int depth, int findDepth, StringBuilder sb, int start) {
        if(depth == findDepth) {
            for(int v : dq) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            dq.offer(arr[i]);
            backTracking(depth + 1, findDepth, sb, i);
            dq.removeLast();
        }
    }
}
