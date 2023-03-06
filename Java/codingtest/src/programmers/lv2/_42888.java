package programmers.lv2;
import java.util.*;
public class _42888 {
    public String[] solution(String[] record) {

        StringBuilder sb = new StringBuilder();
        HashMap<String, String> account = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i],  " ");
            String command = st.nextToken();
            String id = st.nextToken();
            String nickname = "";
            if(st.hasMoreTokens()){
                nickname = st.nextToken();
            }
            if(command.equals("Enter")){
                account.put(id, nickname);
                sb.append(id + "님이 들어왔습니다.,");
            } else if(command.equals("Leave")){
                sb.append(id + "님이 나갔습니다.,");
            } else {
                account.put(id, nickname);
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        String[] answer = sb.toString().split(",");
        for(int i = 0; i < answer.length; i++){
            String log = answer[i];
            int find = log.indexOf("님");
            String key = log.substring(0, find);
            log = log.replace(key, account.get(key));
            answer[i] = log;
        }

        return answer;
    }
}
