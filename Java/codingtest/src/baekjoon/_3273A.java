package baekjoon;

import java.io.*;
import java.util.*;
public class _3273A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] value = br.readLine().split(" ");
        int focus = Integer.parseInt(br.readLine());
        int count = 0;

        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(value[i]);
        }

        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while(true){
            if(l >= r)
                break;
            if(arr[l] + arr[r] < focus){
                l++;
                continue;
            }

            if(arr[l] + arr[r] > focus){
                r--;
                continue;
            }

            if(arr[l] + arr[r] == focus){
                count++;
                l++;
                r--;
            }
        }

        System.out.println(count);
    }
}
