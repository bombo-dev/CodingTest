package baekjoon._11659;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        init();
        play();
        System.out.print(sb);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        arr = new int[N];
        dp = new int[N];
        initArr();
        initDp();
    }

    static void initArr() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }
    }

    static void initDp() {
        dp[0] = arr[0];
        for(int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
    }

    static void play() throws IOException {
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;

            if(start != 0) {
                sb.append(dp[end] - dp[start - 1]).append("\n");
            } else {
                sb.append(dp[end]).append("\n");
            }
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
