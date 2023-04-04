package baekjoon;

import java.io.*;
import java.util.*;
public class _1182 {
    static int N;
    static int S;
    static boolean[] visited;
    static int[] value;
    static int result = 0;

    // 해당 케이스의 모든 경우의 수 2^20
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        value = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            StringBuilder sb = new StringBuilder();
            backTracking(0, i + 1, 0, 0, sb);
        }

        System.out.print(result);
    }

    public static void backTracking(int start, int findDepth, int preDepth, int sum, StringBuilder sb) {

        System.out.println("현재 저장된 값 : " + sb.toString());

        if(findDepth == preDepth) {
            if(sum == S) {
                result++;
            }
            return;
        }

        for(int i = start; i < N; i++){
            visited[i] = true;
            System.out.println("값 " + value[i] + "추가");
            sb.append(value[i]).append(" ");
            backTracking(i + 1, findDepth, preDepth + 1, sum + value[i], sb);
            sb.delete(sb.length() - 2, sb.length());
            System.out.println("값 " + value[i] + "삭제");
            visited[i] = false;
        }
    }
}
