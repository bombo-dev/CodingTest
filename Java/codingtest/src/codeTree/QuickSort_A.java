package codeTree;

import java.io.*;
public class QuickSort_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] value = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(value[i]);
        }

        quickSort(arr, 0, arr.length - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high)
            return;

        int pivot = selectPivot(arr, low, high);
        int pos = low - 1;
        int right = low;

        while (right < pivot) {
            if (arr[right] <= arr[pivot]) {
                int temp = arr[right];
                arr[right] = arr[++pos];
                arr[pos] = temp;
            }
            right++;
        }

        int temp = arr[pivot];
        arr[pivot] = arr[++pos];
        arr[pos] = temp;

        quickSort(arr, low, pos - 1);
        quickSort(arr, pos + 1, high);
    }

    public static int selectPivot(int[] arr, int low, int high) {
        // 1. 피벗의 개수가 4개 이상 일 때, 첫번째 값, 중간 값, 마지막 값을 선택한다.
        // 2. 세 개의 값 중 중간 값을 선택한다.
        // 3. 마지막 값과 계산 된 중간 값의 위치를 교체한다.
        // 4. 피벗의 개수가 4개 미만 일 경우, 마지막 값을 선택한다.

        if (high - low + 1 >= 4) {
            int start = low;
            int end = high;
            int mid = (low + high) / 2;

            if (arr[start] >= arr[end]) {
                if (arr[start] >= arr[mid]) {
                    if (arr[mid] >= arr[end]) {
                        pivotSwitch(arr, mid, high);
                    }
                } else {
                    pivotSwitch(arr, start, high);
                }
            } else {
                if (arr[start] >= arr[mid])
                    pivotSwitch(arr, start, high);
                else if (arr[mid] <= arr[end]) {
                    pivotSwitch(arr, mid, high);
                }
            }
        }

        return high;
    }

    public static void pivotSwitch(int[] arr, int select, int high) {
        int temp = arr[select];
        arr[select] = arr[high];
        arr[high] = temp;
    }
}
