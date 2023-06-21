package study._1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int N;
    static int S;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        if (min == Integer.MAX_VALUE) {
            System.out.print(0);
        } else {
            System.out.print(min);
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 10
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        int left = 0;
        int right = 0;
        long sum = arr[left];

        while (left <= right && right < N) {

            if (sum >= S) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            } else {
                if (right < N - 1) {
                    sum += arr[++right];
                } else {
                    break;
                }
            }
        }
    }
}
