package codingbook.search;

import java.io.*;
import java.util.*;
public class Question1 {
    public static String binarySearch(int[] array, int target, int start, int end){
        if(start > end){
            return "no";
        }
        int mid = (start + end) / 2;
        if(array[mid] == target){
            return "yes";
        } else if(target < array[mid]){
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1 , end);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);

        int findCount = Integer.parseInt(br.readLine().trim());
        String[] value = br.readLine().split(" ");

        for(int i = 0; i < value.length; i++){
            int find = Integer.parseInt(value[i]);
            System.out.print(binarySearch(arr, find, 0, n -1) + " ");
        }
    }
}
