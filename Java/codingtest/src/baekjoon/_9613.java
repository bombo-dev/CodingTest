package baekjoon;

import java.io.*;
import java.util.*;

// mapToLong 으로 해야 함.
public class _9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 1 <= n <= 100
        while(T-->0) {
            List<Integer> list = new ArrayList<>();
            String[] value = br.readLine().split(" ");
            int N = Integer.parseInt(value[0]);
            int[] arr = new int[N];
            int[] target = new int[2];

            for(int i = 1; i < value.length; i++) {
                arr[i - 1] = Integer.parseInt(value[i]);
            }
            Arrays.sort(arr);

            // 모든 경우의 수 nC2 * 최고 수 100만 N은 100이 최대이므로, 4950 * 100만이 최대 합 : 따라서 Long
            backTracking(arr, target, 0, 0, list);
            long sum = list.stream().mapToLong(i -> i).sum();
            System.out.println(sum);
        }
    }

    static void backTracking(int[] arr, int[] target, int depth, int start, List<Integer> list) {
        if(depth == 2) {
            int a = target[0];
            int b = target[1];
            int gcd = getGCD(a, b);
            list.add(gcd);
            return;
        }


        for(int i = start; i < arr.length; i++) {
            target[depth] = arr[i];
            backTracking(arr, target, depth + 1, i + 1, list);
        }
    }

    static int getGCD(int a, int b) {
        if(b == 0)
            return a;
        else return getGCD(b, a % b);
    }
}
