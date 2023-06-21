package algorithm.backtracking;

import java.util.Scanner;

public class nm1 {
    public static int n = 0;
    public static int m = 0;
    public static boolean[] isUsed;
    public static int[] arr;
    public static void permutation(int k){

        if(k == m){
            System.out.print("[ ");
            for(int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.print("]");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;
                permutation(k + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(n + " " + m);
        arr = new int[m + 1];
        isUsed = new boolean[n + 1];

        permutation(0);
    }
}
