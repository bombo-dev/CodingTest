import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _135808 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(score).boxed().collect(Collectors.toList());
        list.sort(Collections.reverseOrder());

        
        for(int i = 0; i < score.length; i += m){
            if(i + m <= score.length){
                answer += list.get(i + m - 1) * m;
            }
        }
        return answer;
    }

    public int solution2(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }
        return answer;
    }
}
