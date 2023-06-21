package codingbook.search;

import java.io.*;
import java.util.*;

public class Question2a {
    static int result = 0;

    public static Integer binarySearch(Integer[] arr, int target, int start, int end){
        int total = 0;

        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;

        for(int val : arr){
            if(val - mid > 0){
                total += val - mid;
            }
        }
        if(total < target){
            return binarySearch(arr, target, start, mid - 1);
        } else {
            result = mid;
            return binarySearch(arr, target, mid + 1, end);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);

        Integer[] array = new Integer[n];
        String[] value = br.readLine().split(" ");
        for (int i = 0; i < value.length; i++) {
            array[i] = Integer.parseInt(value[i]);
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        int max = Collections.max(list);

        int start = 0;
        int end = max;

        binarySearch(array, m, 0, end);
        System.out.print(result);
    }
}
