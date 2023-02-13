package codeTree;

import java.io.*;

public class MergeSort_A {
    public static int[] newArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        newArr = new int[N];

        String[] value = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(value[i]);
        }

        merge_sort(arr, 0, arr.length - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }


    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                newArr[k++] = arr[i++];
            else
                newArr[k++] = arr[j++];
        }

        while (i <= mid) {
            newArr[k++] = arr[i++];
        }

        while (j <= high) {
            newArr[k++] = arr[j++];
        }

        for (int l = low; l <= high; l++) {
            arr[l] = newArr[l];
        }
    }

    public static void merge_sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
}
