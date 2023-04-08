package baekjoon;

import java.io.*;
import java.util.*;
public class _6603 {
    static int N;
    static int[] arr;
    static int[] result;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String testCase = br.readLine();
            if(testCase.charAt(0) == '0')
                break;
            StringTokenizer st = new StringTokenizer(testCase, " ");
            sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            result = new int[6];

            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 6, 0, 0);
            System.out.println(sb.toString());
        }
    }

    static void backTracking(int depth, int findDepth, int target, int start) {
        if(depth == findDepth) {
            for(int v : result) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        if(target >= N)
            return;

        for(int i = start; i < N; i++){
            result[target] = arr[i];
            backTracking(depth + 1, findDepth, target + 1, i + 1);
        }
    }
}
