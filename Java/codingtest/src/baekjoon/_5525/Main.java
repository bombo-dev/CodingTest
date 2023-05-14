package baekjoon._5525;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int S;
    static String find;
    static String value;
    static int count;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        find = createFindValue();

        S = Integer.parseInt(br.readLine());
        value = br.readLine();
        value = createValue();
    }

    private static String createFindValue() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append("10");
        }
        sb.append("1");
        return sb.toString();
    }


    private static String createValue() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S; i++) {
            if(value.charAt(i) == 'O')
                sb.append("0");
            else
                sb.append("1");
        }
        return sb.toString();
    }

    static void solve() {
        BigInteger findValue = new BigInteger(find);
        for(int i = 0; i <= S - find.length(); i++) {
            String compareValue = value.substring(i, i + find.length());
            BigInteger compare = new BigInteger(compareValue);
            if(findValue.xor(compare).toString().equals("0")) {
                count++;
            }
        }
        System.out.print(count);
    }
}
