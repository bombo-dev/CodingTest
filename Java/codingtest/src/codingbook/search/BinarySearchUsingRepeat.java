package codingbook.search;

import java.io.*;

public class BinarySearchUsingRepeat {
    public static Integer binarySearch(int[] array, int target, int start, int end){
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(array[mid] == target){
                return mid;
            }

            if(target < array[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
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
        if(arr[result] != find){
            System.out.print("원소가 존재하지 않으며, 원소가 들어갈 위치는 " + result + "입니다.");
        } else {
            System.out.print("원소의 위치는 " + result + "입니다.");
        }
    }
}
