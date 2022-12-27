public class _136798 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int sumValue = 0;

            if(i == 1){
                sumValue = 1;
            } else {
                for(int j = 1; j <= i / 2; j++){
                    if(i % j == 0){
                        sumValue += 1;
                    }
                }
                sumValue += 1;
            }
            if(sumValue > limit){
                sumValue = power;
            }
            answer += sumValue;
        }
        return answer;
    }

    public int solution2(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int sumValue = 0;
            for(int j = 1; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    if(Math.pow(j, 2) == i){
                        sumValue += 1;
                    } else {
                        sumValue += 2;
                    }
                }
            }
            if(sumValue > limit){
                sumValue = power;
            }
            answer += sumValue;
        }
        return answer;
    }
}
