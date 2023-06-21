package algorithm.recursion;

public class Power {
    // (a^b) % m =
    public static int repeatPow(int a, int b, int m){
        int result = 1;

        while(b > 0){
            result = ( result * a ) % m;
            b--;
        }
        return result;
    }

    public static int recursionPow(int a, int b, int m) {
        if(b == 1){
            return a % m;
        }
        int val = recursionPow(a, b / 2, m);
        val = val * val % m;

        if(b % 2 == 0){
            return val;
        } else {
            return val * a % m;
        }
    }


    public static void main(String[] args){
        System.out.println(repeatPow(7, 5, 4));
        System.out.println(recursionPow(10, 11, 12));
    }
}
