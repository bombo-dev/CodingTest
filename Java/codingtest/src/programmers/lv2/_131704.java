package programmers.lv2;

import java.util.*;

public class _131704 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Stack<Integer> stack = new Stack<>();
    static int index = 0;
    static int result = 0;

    public int solution(int[] order) {

        for(int i = 0; i < order.length; i++) {
            pq.offer(i + 1);
        }

        solve(order);
        return result;
    }

    public void solve(int[] orders) {
        boolean isFail = false;

        while(!isFail) {
            if(!stack.isEmpty()) {
                if(stack.peek() == orders[index]) {
                    result++;
                    index++;
                    stack.pop();
                    continue;
                } else {
                    if(pq.isEmpty())
                        break;
                }
            }

            if(!pq.isEmpty()) {
                if(pq.peek() == orders[index]) {
                    pq.poll();
                    index++;
                    result++;
                } else {
                    stack.push(pq.poll());
                }
            }

            if(stack.isEmpty() && pq.isEmpty()){
                return;
            }
        }
    }
}
