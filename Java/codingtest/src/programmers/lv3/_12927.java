package programmers.lv3;

import java.util.*;
public class _12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : works){
            pq.offer(val);
        }
        while(n-- > 0){
            if(pq.peek() != 0){
                pq.offer(pq.poll() - 1);
            }

        }

        if(!pq.isEmpty()){
            answer = (long)Math.pow(pq.poll(), 2);
        }

        while(!pq.isEmpty()){
            answer += (long)Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}
