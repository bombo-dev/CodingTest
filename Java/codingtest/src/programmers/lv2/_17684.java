package programmers.lv2;
import java.util.*;
public class _17684 {
    public int[] solution(String msg) {

        ArrayList<Integer> list = new ArrayList<>();
        HashMap <String, Integer> alpha = new HashMap<>();

        for(int i = 1; i <= 26; i++){
            String ch = Character.toString('A' + i - 1);
            alpha.put(ch, i);
        }
        int index = 0;
        int update = alpha.size() + 1;
        while(index < msg.length()){
            StringBuilder sb = new StringBuilder();
            char str = msg.charAt(index);
            int limit = index + 1;
            sb.append(str);
            while(limit < msg.length()){
                char newStr = msg.charAt(limit);
                sb.append(newStr);
                if(!alpha.containsKey(sb.toString())){
                    alpha.put(sb.toString(), update++);
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
                limit++;
            }
            list.add(alpha.get(sb.toString()));
            index += sb.length();
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
