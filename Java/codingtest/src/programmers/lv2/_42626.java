package programmers.lv2;

import java.util.*;
public class _42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int val : scoville){
            pq.offer((long)val);
        }


        while(pq.peek() < K && pq.size() >= 2){
            pq.offer(pq.poll() + pq.poll() * 2);
            answer++;
        }

        if(pq.size() == 1 && pq.peek() < K){
            return -1;
        }

        return answer;
    }
}
