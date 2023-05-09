package baekjoon._1927;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static int T;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        for(int i = 0; i < T; i++) {
            int value = Integer.parseInt(br.readLine());

            if(isFind(value)){
                if(!pq.isEmpty())
                    sb.append(pq.poll()).append("\n");
                else
                    sb.append(0).append("\n");
            } else {
                pq.offer(value);
            }
        }

        System.out.print(sb);
    }

    static boolean isFind(int value) {
        return value == 0;
    }
}
