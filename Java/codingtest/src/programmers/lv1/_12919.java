package programmers.lv1;

import java.util.Arrays;

public class _12919 {
    public String solution(String[] seoul) {

        String answer = "";

        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim"))
                answer = "김서방은 " + i + "에 있다";
        }

        return answer;
    }

    public String solution2(String[] seoul){
        // 회고
        int x = Arrays.asList(seoul).indexOf("Kim");

        return "김서방은 "+ x + "에 있다";
    }
}
