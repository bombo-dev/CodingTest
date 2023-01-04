package programmers.lv1;

public class _67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int leftIndex = 10;
        int rightIndex = 12;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                leftIndex = numbers[i];
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                rightIndex = numbers[i];
            }

            else {
                if(numbers[i] == 0)
                    numbers[i] = 11;
                int leftDistance = 0;
                int rightDistance = 0;
                if(leftIndex % 3 == 1){
                    leftIndex += 1;
                    leftDistance = Math.abs((leftIndex / 3) - (numbers[i] / 3)) + 1;
                    leftIndex -= 1;
                } else {
                    leftDistance = Math.abs((leftIndex / 3) - (numbers[i] / 3));
                }

                if(rightIndex % 3 == 0){
                    rightIndex -= 1;
                    rightDistance = Math.abs((rightIndex / 3) - (numbers[i] / 3)) + 1;
                    rightIndex += 1;
                } else {
                    rightDistance = Math.abs((rightIndex / 3) - (numbers[i] / 3));
                }

                if(leftDistance < rightDistance){
                    answer += "L";
                    leftIndex = numbers[i];
                } else if(rightDistance < leftDistance) {
                    answer += "R";
                    rightIndex = numbers[i];
                } else {
                    if(hand.equals("left")){
                        answer += "L";
                        leftIndex = numbers[i];
                    } else {
                        answer += "R";
                        rightIndex = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}
