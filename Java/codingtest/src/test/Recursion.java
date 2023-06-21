package test;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    
    static int[] arr = new int[10];
    static int[][] nQueenArr;
    static int count = 0;
    static boolean[] check;
    static boolean[] leftCheck;
    static boolean[] rightCheck;
    
    public static void main(String[] args) {
//        recursion(0, 0, 0,false);
        nQueen(8);
        System.out.print("count : " + count);
    }

    public static void nQueen(int n){
        nQueenArr = new int[n][n];
        check = new boolean[n];
        leftCheck = new boolean[2 * n - 1];
        rightCheck = new boolean[2 * n - 1];
        DFS(0, 0, n);
    }

    public static void DFS(int r, int c, int n){

        System.out.println("================");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == r && j == c){
                    System.out.print("_ ");
                } else {
                    System.out.print(nQueenArr[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("================");

        if(n == c) return;
        if(n == r) {
            count++;
            return;
        }

        int temp1 = n - r - 1 + c;
        int temp2 = r + c;
        if(!leftCheck[temp1] && !rightCheck[temp2] && !check[c]){
            leftCheck[temp1] = true;
            rightCheck[temp2] = true;
            check[c] = true;
            nQueenArr[r][c] = 1;
            DFS(r + 1, 0, n);
            leftCheck[temp1] = false;
            rightCheck[temp2] = false;
            check[c] = false;
            nQueenArr[r][c] = 0;
        }
        DFS(r, c + 1, n);
    }

    public static void recursion(int n, int count, int tmp, boolean added){
        for(int i=0; i<10; i++){
            System.out.print(i==n-1?"v ":"  ");
        }
        System.out.println();
//        for(int i=0; i<tmp; i++) System.out.print("- ");
        print();
        System.out.printf(" - [%2d]에 ",n-1);
        System.out.print(added?"추가함":"추가하지 않음");

        List<Integer> list = new ArrayList<>();


        if(count == 5) {
            System.out.println(" - 가득참");
//            print();
            return;
        }
        System.out.println();
        
        if(n == 10){
            return;
        }

        arr[n]=1;
        recursion(n+1,count+1, tmp+1, true);
        arr[n]=0;
        recursion(n+1,count, tmp+1, false);
    }

    private static void print() {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
//        System.out.println();
    }
}
