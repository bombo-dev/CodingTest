package baekjoon;

import java.io.*;
import java.util.*;
public class _2490 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr;

        for(int i = 0; i < 3; i++) {
            arr = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreElements()) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
            if(arr[0] == 0) {
                System.out.println("E");
            }
            else if(arr[0] == 1) {
                System.out.println("A");
            } else if(arr[0] == 2) {
                System.out.println("B");
            } else if(arr[0] == 3) {
                System.out.println("C");
            } else if(arr[0] == 4) {
                System.out.println("D");
            }
        }
    }
}
