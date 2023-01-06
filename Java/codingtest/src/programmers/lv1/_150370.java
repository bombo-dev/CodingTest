package programmers.lv1;

import java.util.*;
import java.util.List;

public class _150370 {

    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        String[] todayValue = today.split("\\.");
        int year = Integer.parseInt(todayValue[0]);
        int month = Integer.parseInt(todayValue[1]);
        int day = Integer.parseInt(todayValue[2]);

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < terms.length; i++){
            String[] term = terms[i].split(" ");
            String a = term[0];
            Integer b = Integer.parseInt(term[1]);
            map.put(a, b);
        }

        for(int i = 0; i < privacies.length; i++){
            String[] value = privacies[i].split(" ");
            String date = value[0];

            String[] date_split = date.split("\\.");
            int date_year = Integer.parseInt(date_split[0]);
            int date_month = Integer.parseInt(date_split[1]);
            int date_day = Integer.parseInt(date_split[2]);

            String term = value[1];

            if(date_day - 1 < 1){
                date_day = 28;
                date_month -= 1;
                if(date_month < 1){
                    date_month = 12;
                    date_year -= 1;
                }
            } else {
                date_day -= 1;
            }

            if(date_month + map.get(term) > 12){
                if((date_month + map.get(term)) % 12 == 0){
                    date_year += (date_month + map.get(term)) / 12 - 1;
                    date_month = 12;
                }
                else{
                    date_year += (date_month + map.get(term)) / 12;
                    date_month = (date_month + map.get(term)) % 12;
                }
            } else {
                date_month += map.get(term);
            }

            System.out.println("계산된 날짜 : " + date_year + "." + date_month + "." + date_day);

            if(date_year < year){
                answer.add(i + 1);
            } else if(date_year == year && date_month < month){
                answer.add(i + 1);
            } else if(date_year == year && date_month == month && date_day < day){
                answer.add(i + 1);
            }

        }
        return answer;
    }
}
