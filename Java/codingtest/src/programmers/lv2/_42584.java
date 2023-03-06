package programmers.lv2;
import java.util.*;

public class _42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        LinkedList<Integer> list = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < prices.length; i++){
            list.add(prices[i]);
        }

        int index = 0;
        while(!list.isEmpty()){
            int price = list.get(0);
            list.remove(0);
            Iterator<Integer> iter = list.listIterator();
            while(iter.hasNext()){
                int next = iter.next();
                q.offer(next);
                if(next < price)
                    break;
            }
            answer[index] = q.size();
            index++;
            q.clear();
        }


        return answer;
    }
}
