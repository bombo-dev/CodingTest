package codingbook.greedy.practical;

import java.io.*;
import java.util.*;
public class Practical1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[n];
        String [] value = br.readLine().split(" ");
        for(int i = 0; i < value.length; i++){
            arr[i] = Integer.parseInt(value[i]);
        }

        Arrays.sort(arr);

        int count = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            count += 1;
            if(count >= arr[i]) {
                result += 1;
                count = 0;
            }
        }
        System.out.println(result);
    }
}
