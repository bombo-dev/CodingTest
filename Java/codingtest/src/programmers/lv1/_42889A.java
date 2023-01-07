package programmers.lv1;

import java.util.*;

class StageA implements Comparable<StageA>{
    int stageNum;
    double failure;

    public StageA(int stageNum, double failure){
        this.stageNum = stageNum;
        this.failure = failure;
    }

    @Override
    public int compareTo(StageA o1){
        if(this.failure == o1.failure)
            return this.stageNum - o1.stageNum;

        if(o1.failure - this.failure > 0){
            return 1;
        } else {
            return -1;
        }
    }

}
public class _42889A {
    public int[] solution(int N, int[] stages) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < stages.length; i++){
            map.put(stages[i], map.getOrDefault(stages[i], 0) + 1);
        }

        int[] stageChallenger = new int[N + 1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() <= N){
                for(int i = 1; i <= entry.getKey(); i++){
                    stageChallenger[i] += entry.getValue();
                }
            } else {
                for(int i = 1; i <= N; i++){
                    stageChallenger[i] += entry.getValue();
                }
            }
        }

        Double[] failure = new Double[N];

        for(int i = 1; i <= N; i++){
            if(map.getOrDefault(i, 0) == 0){
                failure[i - 1] = 0.0;
            } else {
                failure[i - 1] = (double)map.get(i) / stageChallenger[i];
            }
        }

        List<StageA> list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            list.add(new StageA(i, failure[i - 1]));
        }

        Collections.sort(list);

        int[] answer = new int[N];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).stageNum;
        }


        return answer;
    }
}
