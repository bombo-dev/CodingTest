package baekjoon;

import java.io.*;
import java.util.*;

// 투 포인터, 이분 탐색, 시간 복잡도를 철저하게 계산해야 했던 문제
// 중간에서 만나기 라는 기술을 사용 가능 (Meet in the middle)
public class _2995 {
    static Long[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        // NlogN
        Arrays.sort(arr);

        ArrayList<Long> newSum = new ArrayList<>();
        //N^2
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++) {
                newSum.add(arr[i] + arr[j]);
            }
        }
        //NlogN
        Collections.sort(newSum);

        // N^2 + NlogN + NlogN

        for(int i = N - 1; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                long nextValue = arr[i] - arr[j];

                // N^2logN
                if(Collections.binarySearch(newSum, nextValue) >= 0) {
                    System.out.print(arr[i]);
                    return;
                }
            }
        }
    }
}
