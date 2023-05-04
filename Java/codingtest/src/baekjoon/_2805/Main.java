package baekjoon._2805;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int max = Integer.MIN_VALUE;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        init();
        solve(0, max);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new Integer[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
            max = Math.max(max, arr[i]);
        }
    }

    static void solve(int start, int end) {

        int maxValue = start;
        while(start <= end) {
            int mid = (start + end) / 2;

            long targetValue = calc(mid);

            if(targetValue >= M) {
                maxValue = Math.max(maxValue, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(maxValue);
    }

    static long calc(int mid) {
        long total = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - mid < 0)
                continue;
            total += arr[i] - mid;
        }
        return total;
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
