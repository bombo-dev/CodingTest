import java.io.*;
import java.util.*;

//bottom-up DP Table
public class Fibonacci2 {
    public static int[] dpT = new int[100];

    public static void main(String[] args) throws IOException{
        dpT[1] = 1;
        dpT[2] = 1;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 3; i < n + 1; i++){
            dpT[i] = dpT[i - 1] + dpT[i - 2];
        }

        System.out.print(dpT[n]);
    }
}
