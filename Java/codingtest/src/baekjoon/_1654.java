package baekjoon;

import java.io.*;
import java.util.*;

public class _1654 {
    static int K;
    static int N;
    static long[] arr;
    static long maxIndex;
    static long minIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 총 길이로 잘리는 지 찾기 K^2/2 -> 5천만

        minIndex = 0;
        maxIndex = arr[K - 1] + 1;

        for (int i = 0; i < K; i++) {
            int total = 0;
            for (int j = i; j < K; j++) {
                total += arr[j] / arr[i];
            }
            if (total >= N) {
                minIndex = Math.min(minIndex, arr[i]);
            } else {
                maxIndex = Math.max(maxIndex, arr[i]);
                break;
            }
        }
        // UpperBound 이진 탐색
        long maxLength = UpperBound();
        System.out.print(maxLength);
    }

    static long UpperBound() {
        long start = minIndex;
        long end = maxIndex;

        long findUpper = maxIndex;

        while (start <= end) {
            long mid = (start + end) / 2;
            // 해당 수로 나뉘어지는지 계산
            if (!findLan(mid)) {
                end = mid - 1;
                findUpper = Math.min(findUpper, mid);
            } else {
                start = mid + 1;
            }
        }
        return findUpper - 1;
    }

    static boolean findLan(long number) {
        int total = 0;

        // total 이 무조건 N 보다 큰 경우
        if(number == 0)
            return true;

        for (int i = 0; i < K; i++) {
            total += arr[i] / number;
        }

        return total >= N;
    }
}
