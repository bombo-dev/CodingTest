package baekjoon;

import java.io.*;
import java.util.*;
public class _1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        Arrays.sort(arr);
        for(int i = 0; i < M; i++){
            int findValue = Integer.parseInt(st.nextToken());
            Integer find = binarySearch(arr, findValue);
            if(find != null) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static Integer binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == target)
                return mid;

            if(arr[mid] > target) {
                end = mid - 1;
            } else if(arr[mid] < target) {
                start = mid + 1;
            }
        }
        return null;
    }
}
