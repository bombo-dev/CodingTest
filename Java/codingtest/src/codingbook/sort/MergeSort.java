package codingbook.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args){

        int[] n = {21, 10, 12, 20, 25, 13, 15, 22};
        merge_sort(n, 0, n.length - 1);

        for(int value : result){
            System.out.print(value +  " ");
        }
    }

    public static void merge(int[] list, int left, int mid, int right){

        int leftStart = left;
        int rightEnd = right;
        int rightStart = mid + 1;

        while(left<=mid && rightStart<=right){
            if(list[left] <= list[rightStart])
                result.add(list[left++]);
            else
                result.add(list[rightStart++]);
        }
        if(left <= mid){
            result.add(list[left++]);
        }
        if(rightStart <= right){
            result.add(list[right++]);
        }

        for(int i = leftStart; i < rightEnd; i++){
            list[i] = result.get(i);
        }
    }

    public static void merge_sort(int[] list, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            merge_sort(list, left, mid);
            merge_sort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
}
