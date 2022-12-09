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
