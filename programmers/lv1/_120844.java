public class _120844 {
    public int[] solution(int[] numbers, String direction) {
        if (direction.equals("right")) {
            int last = numbers[numbers.length - 1];
            for (int i = numbers.length - 1; i > 0; i--) {
                numbers[i] = numbers[i - 1];
            }
            numbers[0] = last;
        } else {
            int first = numbers[0];
            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            numbers[numbers.length - 1] = first;
        }

        int[] answer = numbers;
        return answer;
    }
}
