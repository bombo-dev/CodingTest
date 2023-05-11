package baekjoon._11047;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int K;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        int maxIndex = findIndex();
        int count = 0;
        while(K > 0) {
            if(arr[maxIndex] != 1) {
                count += (K / arr[maxIndex]);
                K %= arr[maxIndex];
                maxIndex--;
            } else {
                count += K;
                K = 0;
                break;
            }
        }

        System.out.print(count);
    }

    static int findIndex() {
        for(int i = N - 1; i >= 0; i--) {
            if((K / arr[i]) != 0) {
                return i;
            }
        }
        return 0;
    }
}
