package baekjoon;

import java.io.*;
import java.util.*;
public class _15654 {
    static int N;
    static int M;
    static int[] number;
    static int[] printTarget;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        number = new int[N];
        visited = new boolean[N];
        printTarget = new int[M];

        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        backTracking(0, M, 0);
        System.out.println(sb.toString());
    }

    static void backTracking(int depth, int findDepth, int target) {

        if(depth == findDepth) {
            for(int i = 0; i < M; i++){
                sb.append(printTarget[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                printTarget[target] = number[i];
                backTracking(depth + 1, findDepth, target + 1);
                visited[i] = false;
            }
        }
    }
}
