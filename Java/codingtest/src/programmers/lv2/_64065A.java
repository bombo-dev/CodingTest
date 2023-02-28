package programmers.lv2;
import java.util.*;
public class _64065A {
    public int[] solution(String s) {
        s = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim();
        String[] value = s.split(" , ");

        Arrays.sort(value, new Comparator<String>() {
            @Override
            public int compare(String a1, String a2){
                return a1.length() - a2.length();
            }
        });

        Set<Integer> set = new HashSet<>();
        int[] answer = new int[value.length];

        int index = 0;
        for(String val : value){
            StringTokenizer st = new StringTokenizer(val, ",");
            while(st.hasMoreElements()){
                int insert = Integer.parseInt(st.nextToken());
                if(set.add(insert)){
                    answer[index++] = insert;
                }
            }
        }
        return answer;
    }
}
