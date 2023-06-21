package codingbook.search;

import java.io.*;
import java.util.*;

public class Question1b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[1000001];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            int radix = Integer.parseInt(s[i]);
            arr[radix] += 1;
        }
        int findCount = Integer.parseInt(br.readLine().trim());
        String[] value = br.readLine().split(" ");

        for(String val : value){
            int resultValue = Integer.parseInt(val);
            if(arr[resultValue] >= 1){
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
