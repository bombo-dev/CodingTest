package codingbook.search;

import java.io.*;

public class BinarySearchUsingRecursion {
    public static Integer binarySearch(int[] array, int target, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        }

        if(target < array[mid]){
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, end);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int find = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        String[] value = br.readLine().split(" ");
        for(int i = 0; i < value.length; i++){
            arr[i] = Integer.parseInt(value[i]);
        }

        Integer result = binarySearch(arr, find, 0, n - 1);
        if(result == null){
            System.out.print("원소가 존재하지 않습니다.");
        } else {
            System.out.print(result);
        }
    }
}
