package programmers.lv1;

public class _12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = (long)x;

        for(int i = 1 ; i < n; i++){
            answer[i] = (long)((long)x + (long)x * (long)i);
        }

        return answer;
    }

    public long[] solution2(int x, int n){
        long[] answer = new long[n];
        answer[0] = x;

        for(int i = 1 ; i < n; i++){
            answer[i] = answer[i - 1] + x;
        }

        return answer;
    }
}
