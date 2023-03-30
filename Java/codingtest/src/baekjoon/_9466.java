package baekjoon;

import java.io.*;
import java.util.*;

public class _9466 {

    static boolean[] visited;
    static boolean[] finished;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            result = 0;
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j <= N; j++) {
                dfs(j);
            }
            System.out.println(N - result);
        }
    }

    public static void dfs(int now) {
        if(visited[now])
            return;

        visited[now] = true;
        int next = arr[now];

        if(!visited[next])
            dfs(next);
        else {
            if(!finished[next]) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                result++;
                for(int i = next; i != now; i = arr[i])
                    result++;
            }
        }

        // 모든 작업이 끝나서 더이상 사용하지 않음
        finished[now] = true;
    }
}
