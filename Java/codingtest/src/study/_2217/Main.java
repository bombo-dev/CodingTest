package study._2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        N = stoi(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(stoi(br.readLine()));
        }

        int size = 0;
        while (!pq.isEmpty()) {
            int weight = pq.poll();
            size++;

            max = Math.max(weight * size, max);
        }

        System.out.print(max);
    }

    static int stoi(String value) {
        return Integer.parseInt(value);
    }
}
