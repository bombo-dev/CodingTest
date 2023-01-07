package programmers.lv1;

import java.util.*;

// 회고해야 되는 부분
// 1. 소수 비교
// 2. Math.round 소수 n 번째 자리표시, String.format 도 추가
// 3. list.sort() -> Comparator 만 사용 가능
// 4. 객체 타입에서는 Comparable 만 사용 가능



class Stage implements Comparable<Stage> {
    private int stageNumber;
    private int stageChallengeCount;
    private int stageStoppedCount;

    public Stage(int stageNumber, int stageChallengeCount, int stageStoppedCount){
        this.stageNumber = stageNumber;
        this.stageChallengeCount = stageChallengeCount;
        this.stageStoppedCount = stageStoppedCount;
    }

    public int getStageNumber(){
        return this.stageNumber;
    }

    public int getStageChallengeCount() {
        return this.stageChallengeCount;
    }

    public int getStageStoppedCount() {
        return this.stageStoppedCount;
    }

    public void setStageNumber(int stageNumber){
        this.stageNumber = stageNumber;
    }

    public void setStageChallengeCount(int stageChallengeCount) {
        this.stageChallengeCount = stageChallengeCount;
    }

    public void setStageStoppedCount(int stageStoppedCount) {
        this.stageStoppedCount = stageStoppedCount;
    }

    public double getFailure(){
        if(this.stageChallengeCount == 0){
            return 0;
        }
        return (double)this.stageStoppedCount / this.stageChallengeCount;
    }

    @Override
    public int compareTo(Stage o2){
        if(o2.getFailure() - this.getFailure() == 0)
            return this.getStageNumber() - o2.getStageNumber();
        if(o2.getFailure() - this.getFailure() < 0)
            return -1;
        else
            return 1;
    }
}
public class _42889 {

    public static void main(String[] args){
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(5, stages);
    }


    public static List<Integer> solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int stage : stages){
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }

        List<Stage> list = new ArrayList<>();
        for(int i = 1; i <= N + 1; i++){
            list.add(new Stage(i, 0, 0));
        }

        // 0이 1스테이지, 1이 2스테이지 , 2가 3스테이지

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            for(int i = 0; i < entry.getKey(); i++){
                list.get(i).setStageChallengeCount(list.get(i).getStageChallengeCount() + entry.getValue());
            }
            list.get(entry.getKey() - 1).setStageStoppedCount(entry.getValue());
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getStageNumber() <= N)
                answer.add(list.get(i).getStageNumber());
        }

        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }
        return answer;
    }
}
