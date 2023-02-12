package codeTree;

import java.io.*;
import java.util.*;

public class RadixSort_A {
    static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] value = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(value[i]);
            maxLength = Math.max(maxLength, String.valueOf(arr[i]).length());
        }

        arr = radixSort(arr, 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] radixSort(int[] arr, int size) {

        ArrayList<Integer> storeList = new ArrayList<>();
        int[] storeArr = new int[arr.length];

        if (maxLength < size)
            return arr;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < arr.length; i++) {
            int valueLength = String.valueOf(arr[i]).length();
            if (valueLength < size) {
                list.get(0).add(arr[i]);
                continue;
            }
            int radix = String.valueOf(arr[i]).charAt(valueLength - size) - '0';
            list.get(radix).add(arr[i]);
        }

        for (int i = 0; i < 10; i++) {
            for (int val : list.get(i))
                storeList.add(val);
        }

        for (int i = 0; i < storeList.size(); i++) {
            storeArr[i] = storeList.get(i);
        }

        return radixSort(storeArr, size + 1);
    }
}
