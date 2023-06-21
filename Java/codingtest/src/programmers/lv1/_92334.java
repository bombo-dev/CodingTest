package programmers.lv1;

import java.util.*;

public class _92334 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        //<String, String> 리스트
        Map<String, Set<String>> reporter = new HashMap<>();
        //<String, Integer> 신고 수
        Map<String, Integer> reported = new HashMap<>();
        //<String, Integer> 메일 수
        Map<String, Integer> mail = new HashMap<>();


        for(int i = 0; i < id_list.length; i++){
            reporter.put(id_list[i], new HashSet<>());
            reported.put(id_list[i], 0);
            mail.put(id_list[i], 0);
        }

        for(int i = 0; i < report.length; i++){
            String[] value = report[i].split(" ");
            String a = value[0];
            String b = value[1];
            if(reporter.get(a).add(b)){
                if(reported.get(b) + 1 <= k){
                    reported.put(b, reported.get(b) + 1);
                }
                if(reported.get(b) == k){
                    for(Map.Entry entry : reporter.entrySet()){
                        if(reporter.get((String)entry.getKey()).contains(b))
                            mail.put((String)entry.getKey(), mail.get((String)entry.getKey()) + 1);
                    }
                }
            }
        }
        int [] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            result[i] = mail.get(id_list[i]);
        }

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + ",");
        }
    }
}
