package programmers.lv2;

import java.util.*;
public class _42883 {
    public String solution(String number, int k) {

        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder();

        int greedy = 0;

        for(int i = 0; i < number.length(); i++) {
            int value = stoi(number.charAt(i));

            if(stack.isEmpty()) {
                stack.push(value);
            } else {
                while(!stack.isEmpty() && greedy < k){
                    if(stack.peek() < value) {
                        stack.pop();
                        greedy++;
                    } else {
                        break;
                    }
                }
                stack.push(value);
            }
        }

        if(stack.size() > (number.length() - k)) {
            int remainValue = k - (number.length() - stack.size());
            for(int i = 0; i < remainValue; i++) {
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    int stoi(char ch) {
        return Character.getNumericValue(ch);
    }
}
