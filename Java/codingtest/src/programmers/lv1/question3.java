package programmers.lv1;

import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int temp = 0;

        for(int i = 0; i < score.length; i++) {
            // 추가하고
            priorityQueue.add(score[i]);
            // 여기서 알아서 정렬되는데, 가장 낮은 숫자가 빠지면 되니까
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }
        return answer;
    }
}
