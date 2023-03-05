package programmers.lv3;

public class _12938A {
    public int[] solution(int n, int s){

        if(n > s){
            return new int[]{-1};
        }

        int remain = s % n;

        int[] answer = new int[n];
        for(int i = n - 1; i >= 0; i--){
            if(remain > 0){
                answer[i] = s / n + 1;
                remain--;
            } else {
                answer[i] = s / n;
            }
        }
        return answer;
    }
}
