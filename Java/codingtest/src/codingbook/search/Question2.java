package codingbook.search;

import java.io.*;
import java.util.*;

public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);

        Integer[] array = new Integer[n];
        String[] value = br.readLine().split(" ");
        for(int i = 0; i < value.length; i++){
            array[i] = Integer.parseInt(value[i]);
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        int max = Collections.max(list);

        int start = 0;
        int end = max;
        int result = 0;

        while(start <= end){
            int total = 0;
            int mid = (start + end) / 2;

            for(int val : array){
                if(val - mid >= 0){
                    total += val - mid;
                } else{
                    total += 0;
                }
            }
            // 반으로 잘랐다. 가져갈 양이 부족해 -> 그러면 더 많이 잘라줘야돼 그러면 지금 mid 보다 더 잘라서 mid +1 을 구해줘야 돼
            // 근데 잘랐어. total이 m보다 크네? 그럼 최댓값을 구해야되니까 그 사이에 값을 구해야지

            if(total < m){
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.print(result);
    }
}
