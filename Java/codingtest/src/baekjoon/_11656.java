package baekjoon;

import java.io.*;
import java.util.*;
public class _11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(value);
        String[] arr = new String[value.length()];

        //substring 을 이용한 풀이도 좋다.
        for(int i = 0; i < arr.length; i++){
            arr[i] = sb.toString();
            sb.deleteCharAt(0);
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
