package programmers.lv1;

import java.util.*;
public class _42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        boolean[] check = new boolean[n + 1];
        Arrays.fill(check, true);

        for(int i = 0; i < lost.length; i++){
            answer--;
            check[lost[i]] = false;
        }

        List<Integer> reserveList = new ArrayList<>();

        for(int i = 0; i < reserve.length; i++){
            reserveList.add(reserve[i]);
        }

        Collections.sort(reserveList);

        for(int i = 0; i < reserveList.size(); i++){
            if(check[reserveList.get(i)] == false){
                check[reserveList.get(i)] = true;
                reserveList.remove(i);
                i--;
                answer++;
            }
        }

        for(int i = 0; i < reserveList.size(); i++){
            if(check[reserveList.get(i) - 1] == false){
                check[reserveList.get(i) - 1] = true;
                reserveList.remove(i);
                i--;
                answer++;
            } else if(reserveList.get(i) + 1 <= n && check[reserveList.get(i) + 1] == false){
                check[reserveList.get(i) + 1] = true;
                reserveList.remove(i);
                i--;
                answer++;
            }
        }

        return answer;
    }
}
