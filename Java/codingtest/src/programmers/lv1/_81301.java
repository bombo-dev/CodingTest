package programmers.lv1;

import java.util.*;

public class _81301 {
    public static void main(String[] args){
        int answer = 0;
        String s = "four0zero23eight";
        String answerString = s;
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            answerString = answerString.replace(entry.getKey(), entry.getValue().toString());
        }
        answer = Integer.parseInt(answerString);
        System.out.println(answer);
        System.out.println(solution2(s));
    }

    public static int solution2(String s){

        String[] value = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String answer = s;
        for(int i = 0; i < 10; i++){
            answer = answer.replace(value[i], Integer.toString(i));
        }

        return Integer.parseInt(answer);
    }
}
