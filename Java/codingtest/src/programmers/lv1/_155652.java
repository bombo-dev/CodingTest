package programmers.lv1;

import java.util.*;
public class _155652 {
    public String solution(String s, String skip, int index) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < skip.length(); i++){
            set.add((int)skip.charAt(i));
        }
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            int count = index;
            int position = (int)arr[i];

            while(count > 0){
                position++;
                if(position > 'z')
                    position = 'a';
                if(!set.contains(position))
                    count--;
            }
            arr[i] = (char)position;
        }
        String answer = new String(arr);
        return answer;
    }
}
