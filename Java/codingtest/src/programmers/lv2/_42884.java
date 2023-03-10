package programmers.lv2;

import java.util.*;

public class _42884 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });

        int max = routes[0][1];
        answer = 1;
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] <= max)
                continue;
            else{
                max = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
