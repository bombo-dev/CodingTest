package programmers.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public int[] solution2(int[] numbers, String direction) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        if (direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        } else {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

