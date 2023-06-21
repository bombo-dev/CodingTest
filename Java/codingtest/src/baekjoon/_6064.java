package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class _6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int result = -1;
        Loop1 : while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            if(X > Y) {
                X = max; Y = min;
            } else {
                Y = max; X = min;
            }

            int LCM = (X * Y) / getGCD(max, min);


        }


    }

    // GCD : 최대 공약수, LCM : 최소 공배수
    static int getGCD(int a, int b) {
        if(b == 0)
            return a;
        else return getGCD(b, a % b);
    }
}
