package baekjoon._15829;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int L;
    static String value;
    static HashMap<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        L = stoi(br.readLine());
        for(int i = 0; i < 26; i++) {
            map.put((char)('a' + i), i + 1);
        }
        value = br.readLine();
    }

    static void solve() {
        long sum = 0;
        for(int i = 0; i < L; i++) {
            int hashValue = map.get(value.charAt(i));
            BigInteger value = new BigInteger(String.valueOf(hashValue));
            BigInteger pow = new BigInteger(String.valueOf(31)).pow(i);
            BigInteger mod = new BigInteger(String.valueOf(1234567891));
            BigInteger result = value.multiply(pow);
            BigInteger last = result.add(new BigInteger(String.valueOf(sum))).mod(mod);
            sum = last.intValue();
        }
        System.out.print(sum);
    }

    static void print() {
        for(char c : map.keySet()) {
            System.out.println("key : " + c + " value : " + map.get(c));
        }
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
