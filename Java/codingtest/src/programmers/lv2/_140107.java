package programmers.lv2;

public class _140107 {
    public long solution(int k, int d) {
        long answer = 0;

        for(int i = 0; i <= d; i = i + k){
            double maxLength = Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            answer += (long)(Math.floor(maxLength / k) + 1);
        }


        return answer;
    }
}
