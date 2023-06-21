package baekjoon;

import java.io.*;
public class _2587 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        quick(arr, 0, arr.length -1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }


    }

    public static void quick(int[] arr, int start, int end) {

        if (start >= end)
            return;

        int pivot = arr[start];
        int low = start + 1;
        int high = end;

        while(low <= high){
            while(low <= end && arr[low] <= pivot)
                low++;

            while(high > start && arr[high] >= pivot)
                high--;

            if(low > high){
                int temp = pivot;
                arr[start] = arr[high];
                arr[high] = temp;
            } else {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        quick(arr, start, high - 1);
        quick(arr, high + 1, end);
    }
}
