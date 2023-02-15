package codeTree;

public class CustomBound {
    public int customBound(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int maxIndex = -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] <= target){
                left = mid + 1;
                maxIndex = Math.max(maxIndex, mid);
            } else {
                right = mid - 1;
            }
        }
        return maxIndex;
    }
}
