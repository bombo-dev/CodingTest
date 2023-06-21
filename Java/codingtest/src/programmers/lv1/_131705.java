package programmers.lv1;

import java.util.Arrays;

public class _131705 {
    static int answer = 0;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        Arrays.sort(number);
        combination(number, visited, 0, 3);
        return answer;
    }

    public static void combination(int[] number, boolean[] visited, int start, int r){
        if(r == 0) {
            check(number, visited);
            return;
        } else {
            for(int i = start; i < number.length; i++){
                visited[i] = true;
                combination(number, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public static void check(int[] number, boolean[] visited){
        int value = 0;
        for(int i = 0; i < number.length; i++){
            if(visited[i] == true)
                value += number[i];
        }
        if(value == 0){
            answer += 1;
        }
    }
}
