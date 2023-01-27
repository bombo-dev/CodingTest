package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class _17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();

        for(String city : cities){
            if(list.contains(city.toLowerCase())){
                list.remove(list.indexOf(city.toLowerCase()));
                list.add(0, city.toLowerCase());
                answer++;
            } else {
                if(list.size() < cacheSize){
                    list.add(0, city.toLowerCase());
                    answer += 5;
                } else {
                    list.add(0, city.toLowerCase());
                    list.remove(list.size() - 1);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
