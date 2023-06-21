package programmers.lv1;

public class _132267 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int temp = 0;
        while(n > 0){
            temp = 0;
            if(n % a == 0){
                answer += (n/a) * b;
                n = (n/a) * b;
            } else {
                answer += (n/a) * b;
                temp = (n % a);
                n = (n/a) * b;
            }
            if(n + temp >= a){
                n += temp;
            } else {
                break;
            }
        }
        return answer;
    }
}
