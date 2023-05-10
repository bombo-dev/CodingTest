package baekjoon._11399;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        int total = 0;
        int preValue = 0;
        while(!pq.isEmpty()) {
            preValue += pq.poll();
            total += preValue;
        }
        System.out.print(total);
    }
}
