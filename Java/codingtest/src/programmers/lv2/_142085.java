package programmers.lv2;

import java.util.*;

// 디펜스 게임
public class _142085 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < enemy.length; i++){
            if(n >= 0 && pq.size() < k){
                pq.offer(enemy[i]);
            } else if(n >= 0 && pq.size() == k){
                int check = pq.peek();
                if(enemy[i] > pq.peek()){
                    n -= pq.poll();
                    pq.offer(enemy[i]);
                } else{
                    n -= enemy[i];
                }
            }
            if(n < 0)
                break;
            answer++;
        }

        return n < 0 ? answer : enemy.length;
    }
}
