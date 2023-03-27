package baekjoon;

import java.io.*;
import java.util.*;

class Num implements Comparable<Num> {

    int n, idx;

    public Num(int n, int idx) {
        this.n = n;
        this.idx = idx;
    }

    @Override
    public int compareTo(Num o) {
        return n - o.n;
    }
}

public class _11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Num> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.peekLast().n > num) {
                dq.pollLast();
            }
            dq.offerLast(new Num(num, i));
            if(dq.peekFirst().idx < i - L + 1) {
                dq.pollFirst();
            }
            sb.append(dq.peekFirst().n).append(" ");
        }
        System.out.print(sb.toString());
    }
}
