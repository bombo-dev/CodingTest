package programmers.lv2;

import java.util.*;

class Document {
    int number;
    int priority;

    public Document(int number, int priority){
        this.number = number;
        this.priority = priority;
    }
}
public class _42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayDeque<Document> dq = new ArrayDeque<>();

        int max = 0;
        ArrayList<Integer> prior = new ArrayList<>();

        for(int i = 0; i < priorities.length; i++){
            dq.offer(new Document(i, priorities[i]));
            prior.add(priorities[i]);
        }

        Collections.sort(prior, Collections.reverseOrder());

        int index = 0;
        while(!dq.isEmpty()){
            if(dq.peek().priority < prior.get(index)){
                dq.offer(dq.poll());
            } else {
                index++;
                if(dq.poll().number == location)
                    break;
            }
        }
        answer = index;
        return answer;
    }
}
