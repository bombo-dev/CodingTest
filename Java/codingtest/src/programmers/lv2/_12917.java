package programmers.lv2;

import java.util.*;
public class _12917 {
    public int solution(int[] A, int[] B) {
        // 1. 전부다 이기도록 하는게 승점이 가장 높음
        // 2. 만약에 이길 수 있는 숫자가 없다면 가장 작은 숫자로 패배해야 확률이 높음
        // 3. 가장 낮은 수는 가장 낮은 수보다 차이가 가장 적은 수로 이겨야 함
        // 4. 비기는 경우는?
        // 2 4 5 1 8 1
        // 3 5 4 6 1 8
        // 1 1 2 4 5 8
        // 1 3 3 4 6 8 -> 5점 , 1이 8한테 지는 경우

        // TestCase :
        // 5, 1, 3, 7 -> 1 3 5 7
        // 8, 2, 6, 2 -> 3점의 승점을 얻을 수 있음 2 2 6 8

        // nlogn

        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        int answer = 0;

        for(int i = 0; i < A.length; i++){
            pqA.offer(A[i]);
            pqB.offer(B[i]);
        }
        while(!pqB.isEmpty()){
            if(pqA.peek() < pqB.peek()){
                pqA.poll();
                pqB.poll();
                answer++;
            } else {
                while(!pqB.isEmpty() && pqA.peek() >= pqB.peek()){
                    pqB.poll();
                }
                if(!pqB.isEmpty()){
                    pqA.poll();
                    pqB.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}
