package codeTree;

public class LowerBound {
    public int lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int minIndex = arr.length;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target){
                right = mid - 1;
                minIndex = Math.min(minIndex, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIndex;
    }
}
