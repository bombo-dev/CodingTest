package baekjoon;

import java.io.*;
import java.util.*;

class Jew implements Comparable<Jew> {

    int weight;
    int value;

    public Jew(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jew j) {
        if(weight == j.weight) {
            return value - j.value;
        }

        return weight - j.weight;
    }
}
public class _1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        PriorityQueue<Jew> jewPq = new PriorityQueue<>(); // 보석 저장소

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewPq.add(new Jew(weight, value));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 가방 저장소
        PriorityQueue<Integer> wpq = new PriorityQueue<>(Comparator.reverseOrder()); // 무게 저장소

        for(int i = 0; i < K; i++) {
            int weight = Integer.parseInt(br.readLine());
            pq.offer(weight);
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            int weight = pq.poll();
            while(!jewPq.isEmpty()) {
                if(jewPq.peek().weight > weight){
                    break;
                }
                wpq.offer(jewPq.poll().value);
            }
            if(!wpq.isEmpty()) {
                sum += wpq.poll();
            }
        }
        System.out.print(sum);
    }
}
