package codingbook.sort;

import java.io.*;
import java.util.*;
public class Question3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int k = Integer.parseInt(init[1]);
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        String[] value1 = br.readLine().split(" ");
        String[] value2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(value1[i]);
            arr2[i] = Integer.parseInt(value2[i]);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            if(arr1[i] >= arr2[i])
                break;
            arr1[i] = arr2[i];
        }

        long result = 0;
        for(int val : arr1){
            result += val;
        }
        System.out.print(result);
    }
}
