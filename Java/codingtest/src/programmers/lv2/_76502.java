package programmers.lv2;

import java.util.*;
public class _76502 {
    public static int count = 0;
    public int solution(String s) {

        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }

        for(int i = 0; i < s.length(); i++){
            if(i != 0){
                char value = list.get(0);
                list.remove(0);
                list.add(value);
            }

            count += checkPattern(list);
        }

        int answer = count;
        return answer;
    }

    public int checkPattern(ArrayList<Character> list){

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals('['))
                stack.push(list.get(i));
            else if(list.get(i).equals('('))
                stack.push(list.get(i));
            else if(list.get(i).equals('{'))
                stack.push(list.get(i));
            else if(list.get(i).equals(']')){
                if(!stack.isEmpty() && stack.peek().equals('['))
                    stack.pop();
                else
                    return 0;
            }
            else if(list.get(i).equals(')')){
                if(!stack.isEmpty() && stack.peek().equals('('))
                    stack.pop();
                else
                    return 0;
            }
            else if(list.get(i).equals('}')){
                if(!stack.isEmpty() && stack.peek().equals('{'))
                    stack.pop();
                else
                    return 0;
            }
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
