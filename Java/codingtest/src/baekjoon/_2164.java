package baekjoon;

import java.io.*;
import java.util.*;
public class _2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            q.offer(i + 1);
        }

        while(q.size() != 1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.print(q.poll());
    }
}
