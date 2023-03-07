package programmers.lv2;

import java.util.*;
public class _131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        boolean check = false;
        int index = 0;
        while(index <= discount.length - 10){
            check = true;

            for(int i = 0; i < want.length; i++){
                map.put(want[i], number[i]);
            }

            for(int i = index; i < index + 10; i++){
                if(map.containsKey(discount[i]) && map.get(discount[i]) > 0)
                    map.put(discount[i], map.get(discount[i]) - 1);
                else {
                    check = false;
                    break;
                }
            }

            if(check)
                answer++;
            index++;
        }


        return answer;
    }
}
