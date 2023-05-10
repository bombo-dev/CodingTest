package baekjoon._11279;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if(!pq.isEmpty()) {
                if(value != 0) {
                    pq.offer(value);
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                if(value == 0)
                    sb.append(0).append("\n");
                else
                    pq.offer(value);
            }
        }
        System.out.print(sb);
    }
}
