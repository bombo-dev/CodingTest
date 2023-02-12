package codeTree;

import java.io.*;

public class InsertionSort_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] value = br.readLine().split(" ");
        for (int i = 0; i < value.length; i++) {
            arr[i] = Integer.parseInt(value[i]);
        }

        arr = insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int[] insertionSort(int[] arr) {
        int[] sortedArr = arr.clone();
        for (int i = 1; i < sortedArr.length; i++) {
            int key = sortedArr[i];
            int j = i - 1;
            while (j >= 0 && sortedArr[j] > key) {
                sortedArr[j + 1] = sortedArr[j];
                j--;
            }
            sortedArr[j + 1] = key;
        }

        return sortedArr;
    }
}
