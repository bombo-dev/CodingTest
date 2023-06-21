package codingbook.dynamicProgramming;

// Top-Down Memoization
public class Fibonacci {
    public static long[] memo = new long[100];
    public static long fibo(int n){
        System.out.print("f(" + n + ") ");

        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = fibo(n - 1) + fibo(n - 2);
        return memo[n];
    }

    public static void main(String[] args){
        System.out.print(fibo(10));
    }
}
