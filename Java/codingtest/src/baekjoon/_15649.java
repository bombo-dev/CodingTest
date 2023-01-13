package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class _15649 {
    static int count = 0;

    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[r];
        check = new boolean[n + 1]; // 0, 1, 2, 3, 4
        solutionPermutation(n, 0, r);
    }

    // 4P2
    public static void solutionPermutation(int n, int depth, int r){

        System.out.println("===============");
        for(int i = 0; i < depth + 1; i++){
            if(depth == i && i < r){
                System.out.print("_ ");
            } else if(i < r){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.println("===============");


        if(depth == r){
            for(int i = 0; i < r; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for(int i = 1; i <= n; i++){
                if(!check[i]){
                    check[i] = true;
                    arr[depth] = i;
                    solutionPermutation(n, depth + 1, r);
                    check[i] = false;
                }
            }
        }

    }
}
