package programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;

public class _86501 {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3, 4, 6, 7, 8, 0};

        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        int answer = 0;
        for(int i = 0 ; i <= 9; i++){
            if(!list.contains(i))
                answer += i;
        }
        System.out.println(answer);
        System.out.println(solution2(numbers));
    }

    public static int solution2(int[] numbers){
        int sum = 45;

        for(int v : numbers)
            sum -= v;
        return sum;
    }
}
