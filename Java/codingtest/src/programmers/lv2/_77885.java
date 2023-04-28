package programmers.lv2;

import java.util.*;
public class _77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        // 수 만큼 시작
        for(int i = 0; i < numbers.length; i++) {
            long start = numbers[i];
            if(numbers[i] % 4 == 3){
                long result = convert(start);
                answer[i] = result;
            } else {
                answer[i] = start + 1;
            }
        }
        return answer;
    }

    Long convert(long value) {
        StringBuilder sb = new StringBuilder();
        String binaryValue = Long.toBinaryString(value);
        sb.append(binaryValue);
        sb.insert(0, "0");

        String convertValue = sb.toString();
        int position = convertValue.lastIndexOf("01");
        String prefix = convertValue.substring(0, position);
        String postfix = convertValue.substring(position + 2);

        sb = new StringBuilder();
        sb.append(prefix).append("10").append(postfix);
        long result = Long.parseLong(sb.toString(), 2);
        return result;
    }
}
