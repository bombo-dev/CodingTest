package baekjoon._11866;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int K;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        init();
        josephus();

    }
    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }
    }

    static void josephus() {
        sb.append("<");
        int count = 0;
        while(!q.isEmpty()) {
            count++;
            if(count == K) {
                count = 0;
                int value = q.poll();
                if(!q.isEmpty()) {
                    sb.append(value).append(", ");
                } else {
                    sb.append(value).append(">");
                }
                continue;
            }
            q.offer(q.poll());
        }
        System.out.print(sb);
    }
}
