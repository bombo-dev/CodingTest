package baekjoon;

import java.io.*;
import java.util.*;
public class _10816 {
    static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        number = new int[N];

        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int result = calc(Integer.parseInt(st.nextToken()));
            sb.append(result).append(" ");
        }
        System.out.print(sb);
    }

    static int calc(int findNumber){
        return upperBound(findNumber) - lowerBound(findNumber);
    }

    static int upperBound(int findNumber){
        int start = 0;
        int end = number.length - 1;
        int minIndex = number.length;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(number[mid] > findNumber){
                end = mid - 1;
                minIndex = Math.min(minIndex, mid);
            } else {
                start = mid + 1;
            }
        }
        return minIndex;
    }

    static int lowerBound(int findNumber){
        int start = 0;
        int end = number.length - 1;
        int minIndex = number.length;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(number[mid] >= findNumber) {
                end = mid - 1;
                minIndex = Math.min(minIndex, mid);
            } else {
                start = mid + 1;
            }
        }
        return minIndex;
    }
}
