package codingbook.sort;

public class Quick {

    public static void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;
        int pivot = start;
        int left = start + 1;
        int right = end;
        while(left <= right){
            while (left <= end && arr[left] <= arr[pivot]) left++;
            while (right > start && arr[right] >= arr[pivot]) right--;

            // 겹치는 순간 피벗이 제 위치를 찾는다.
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 오른쪽에서 시작했을 경우 재 분할을 했을 때 start 가 0 이 아님
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args){
        int[] arr = {3, 4, 2, 12, 3, 9, 81, 32, 100, 23};
        quickSort(arr, 0, arr.length - 1);

        for(int value: arr){
            System.out.print(value + " ");
        }
    }
}
