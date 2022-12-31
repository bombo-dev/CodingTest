package programmers.lv1;

import java.util.*;
import java.util.stream.*;
// 로또의 최고 순위와 최저 순위
public class _77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lottoList = new ArrayList<>(
                Arrays.stream(lottos)
                        .boxed()
                        .collect(Collectors.toList()));

        List<Integer> winList = new ArrayList<>(
                Arrays.stream(win_nums)
                        .boxed()
                        .collect(Collectors.toList()));

        List<Integer> newList = new ArrayList<>();

        Collections.sort(lottoList, Collections.reverseOrder());
        Collections.sort(winList, Collections.reverseOrder());
        int count = 0;
        for(int i = 0; i < winList.size(); i++){
            if(lottoList.get(i) != 0){
                newList.add(lottoList.get(i));
            }
            if(lottoList.contains(winList.get(i))){
                count += 1;
            }
        }

        int min = 7 - count;
        if(min >= 6){
            min = 6;
        }

        int max = 7 - count - (6 - newList.size());
        if(max >= 6){
            max = 6;
        }

        int[] answer = {max, min};
        return answer;
    }

    public int[] solution2(int[] lottos, int[] win_nums){
        List<Integer> list = new ArrayList<>(Arrays.stream(lottos).boxed().collect(Collectors.toList()));
        List<Integer> newList = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < 6; i++){
            if(list.get(i) != 0){
                newList.add(i);
            }
            if(list.contains(win_nums[i]))
                count +=1;
        }

        int min = 7 - count;
//        if(min >= 6){
//            min = 6;
//        }
        int max = 7 - count - (6 - newList.size());
//        if(max >= 6)
//            max = 6;
        int[] answer = {Math.min(max, 6), Math.min(min, 6)};
        return answer;
    }
}
