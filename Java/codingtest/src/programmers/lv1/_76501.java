package programmers.lv1;

// 음양 더하기
public class _76501 {
    public int solution(int[] absolutes, boolean[] signs){
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++){
            if(signs[i])
                answer += absolutes[i];
            else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public int solution2(int[] absolutes, boolean[] signs){
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++){
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }
}
