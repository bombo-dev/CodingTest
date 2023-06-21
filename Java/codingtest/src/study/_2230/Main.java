package study._2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.print(min);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
    }


    private static void solve() {
        int left = 0;
        int right = 0;

        while (right < N && left <= right) {

            if ((arr[right] - arr[left]) == M) {
                min = M;
                break;
            }

            if (arr[right] - arr[left] < M) {
                right++;
            } else {
                min = Math.min(min, arr[right] - arr[left]);
                left++;
            }
        }
    }
}
