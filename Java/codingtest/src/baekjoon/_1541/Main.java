package baekjoon._1541;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<String> q = new LinkedList<>();
    static int minusCount = 0;
    static int plusCount = 0;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        String value = br.readLine();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < value.length()) {
            if (value.charAt(i) == '-' || value.charAt(i) == '+') {
                q.offer(sb.toString());
                q.offer(String.valueOf(value.charAt(i)));
                i++;
                sb = new StringBuilder();
                continue;
            }
            sb.append(value.charAt(i));
            i++;
        }

        q.offer(sb.toString());
    }

    static void print() {
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

    static void solve() {
        boolean isMinus = false;
        int result = 0;

        while(!q.isEmpty()) {
            String value = q.poll();
            if(!isMinus) {
                if (value.equals("+")) {
                    continue;
                } else if (value.equals("-")) {
                    isMinus = true;
                    continue;
                }
                result += Integer.parseInt(value);
            } else {
                if(value.equals("+") || value.equals("-")) {
                    continue;
                }

                result -= Integer.parseInt(value);
            }
        }
        System.out.print(result);
    }
}
