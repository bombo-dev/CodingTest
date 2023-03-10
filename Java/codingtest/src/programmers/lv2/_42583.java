package programmers.lv2;

import java.util.*;

class Truck {
    int insertTime;
    int weight;

    public Truck(int insertTime, int weight){
        this.insertTime = insertTime;
        this.weight = weight;
    }
}
public class _42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int totalWeight = 0;
        Queue<Truck> q = new LinkedList<>();

        while(index < truck_weights.length || !q.isEmpty()){
            answer++;

            // 다리에 차가 있는데, 맨 앞에 있는 차가 다리길이 만큼 건넜을 경우
            if(!q.isEmpty() && answer - q.peek().insertTime == bridge_length){
                totalWeight -= q.poll().weight;
            }

            // 다리에 차가 없는 경우
            if(q.isEmpty() && index < truck_weights.length){
                q.offer(new Truck(answer, truck_weights[index]));
                totalWeight += truck_weights[index++];
                continue;
            }

            // 다리에 차가 있고, 큐가 다리 길이보다 작을 경우
            if(!q.isEmpty() && q.size() < bridge_length){
                if(index >= truck_weights.length)
                    continue;

                // 큐가 다리 길이보다 작은데, 다리 무게를 초과하지 않는 경우
                if(totalWeight + truck_weights[index] <= weight){
                    q.offer(new Truck(answer, truck_weights[index]));
                    totalWeight += truck_weights[index++];
                }
            }
        }

        return answer;
    }
}
