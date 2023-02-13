package codeTree;

import java.io.*;

public class HeapSort_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] value = br.readLine().split(" ");

        int[] arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(value[i - 1]);
        }

        heapSort(arr, arr.length - 1);

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void heapSort(int[] arr, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, n, i);
        }

        for (int i = n; i > 1; i--) {
            swap(arr, 1, i);
            heapify(arr, i - 1, 1);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = i * 2;
        int r = i * 2 + 1;

        if (l <= n && arr[l] > arr[largest]) largest = l;
        if (r <= n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int largest, int i) {
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
    }
}

