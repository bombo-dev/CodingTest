package baekjoon;
import java.io.*;
public class _25305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int cut = Integer.parseInt(init[1]);

        int [] score = new int[n];
        String[] value = br.readLine().split(" ");
        for(int i = 0; i < value.length; i++){
            score[i] = Integer.parseInt(value[i]);
        }

        quick(score, 0, score.length - 1);
        // 100 76 85 93 98
        // 76 85 93 98 100
        // score[score.length] == score[5]
        // answer : 98
        // score[3] -> score.length - 2
        for(int val : score){
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.print(score[score.length - cut]);

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

        quick(arr, start, right - 1);
        quick(arr, right + 1, end);
    }
}
