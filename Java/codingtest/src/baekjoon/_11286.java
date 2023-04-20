package baekjoon;

import java.io.*;
import java.util.*;

public class _11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)){
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if(value == 0){
                if(!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                pq.offer(value);
            }
        }
        System.out.print(sb);
    }
}
