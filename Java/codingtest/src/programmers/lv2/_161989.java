package programmers.lv2;

public class _161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = 0;

        for(int paint : section){
            if(paint >= index){
                index = m + paint;
                answer++;
            }
        }

        return answer;
    }
}
