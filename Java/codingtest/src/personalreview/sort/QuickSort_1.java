package personalreview.sort;

public class QuickSort_1 {
    public static void main(String[] args) {
        int [] n = {2, 3, 7, 9, 1, 3, 4, 5, 5, 6, 8};
        quick(n, 0, n.length - 1);

        for(int value: n){
            System.out.print(value + " ");
        }

    }

    public static void quick(int[] arr, int start, int end){
        if(start >= end)
            return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            while(left <= end && arr[left] <= arr[pivot])
                left++;
            while(right > start && arr[right] >= arr[pivot])
                right--;

            if(left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
        }

        quick(arr, start, right - 1);
        quick(arr, right + 1, end);
    }
}
