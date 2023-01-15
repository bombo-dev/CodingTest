package baekjoon;

import java.io.*;
import java.util.*;
public class _15651 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        int[] arr = new int[r];

        overlapPerm(n, r,  0, arr);
    }

    public static void overlapPerm(int n, int r, int index, int[] arr){

        if(index == r){
            print(arr, arr.length);
            return;
        }

        // 들어가야 하는 값 출력 문
//        for(int i = 0; i < arr.length; i++){
//            if(i == index)
//                System.out.print("_ ");
//            else
//                System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//
//        if(index == r){
//            return;
//        }



        for(int i = 1; i <= n; i++){
            arr[index] = i;
//            System.out.println("인덱스 " + index + "에 값 : " + i + "를 추가함");
            overlapPerm(n, r, index + 1, arr);
        }
    }

    public static void print(int[] arr, int length){
        for(int i = 0; i < length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
