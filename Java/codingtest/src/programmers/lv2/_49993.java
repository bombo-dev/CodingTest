package programmers.lv2;

import java.util.*;
public class _49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();



        for(int i = 0; i < skill.length(); i++){
            map.put(skill.charAt(i), i);
        }

        for(int i = 0; i < skill_trees.length; i++){
            boolean possible = true;
            int priority = 0;
            for(int j = 0; j < skill_trees[i].length(); j++){
                char find = skill_trees[i].charAt(j);
                if(map.containsKey(find) && map.get(find) != priority){
                    possible = false;
                    break;
                } else if(!map.containsKey(find)){
                    continue;
                } else {
                    priority++;
                }
            }
            if(possible)
                answer++;
        }

        return answer;
    }
}
