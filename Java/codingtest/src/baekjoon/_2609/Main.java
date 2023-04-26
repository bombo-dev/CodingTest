package baekjoon._2609;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {
        init();
        printGCDLCM(a, b);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    static void printGCDLCM(int a, int b) {
        int GCD = getGCD(a, b);
        int LCM = (a * b) / GCD;
        sb.append(GCD).append("\n").append(LCM);
        System.out.print(sb);
    }

    static int getGCD(int a, int b) {

        if(b == 0)
            return a;

        return getGCD(b, a % b);
    }
}
