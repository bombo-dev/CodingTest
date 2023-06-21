package baekjoon;

import java.io.*;
import java.util.*;

public class _1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기존 카드 우선순위 큐
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            pq.offer(value);
        }
        PriorityQueue<Integer> toPq = new PriorityQueue<>(); // 묶음이 저장되는 우선순위 큐

        // 우선순위 큐에 있는 2개를 합친다.
        // 만약 우선순위 큐에서 탐색 한 2개가 이전의 합과 동일하면, 데이터를 합치고
        // 동일하지 않다면 해당 이전의 합을 우선순위 큐에 넣는다.
        // 반복한다.

        int total = 0;

        // pq가 빌 때 까지 반복
        while (!pq.isEmpty()) {
            int calc = 0;
            int firstValue = pq.poll();

            // 연산 이후 값이 존재할 경우
            if(!toPq.isEmpty()) {
                if(pq.isEmpty()) {
                    calc = firstValue + toPq.poll();
                    total += calc;
                    toPq.offer(calc);
                } else if(firstValue + toPq.peek() <= firstValue + pq.peek()) {
                    calc = firstValue + toPq.poll();
                    toPq.offer(calc);
                    total += calc;
                } else {
                    calc = firstValue + pq.poll();
                    toPq.offer(calc);
                    total += calc;
                }
            } else {
                if(pq.isEmpty()) {
                    total += firstValue;
                } else {
                    calc = firstValue + pq.poll();
                    toPq.offer(calc);
                    total += calc;
                }
            }
        }
        if(!toPq.isEmpty()) {
            if(toPq.size() == 1){
                total += toPq.poll();
            } else if(toPq.size() == 2) {
                total += toPq.poll() + toPq.poll();
            }
        }
        System.out.print(total);
    }
}
