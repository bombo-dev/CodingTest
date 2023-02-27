package programmers.lv2;

import java.util.*;

public class _42578A {
    static Map<String, Integer> map;

    public int solution(String[][] clothes) {
        int answer = 1;
        map = new HashMap<>();

        for (String[] value : clothes) {
            map.put(value[1], map.getOrDefault(value[1], 0) + 1);
        }

        for (String value : map.keySet()) {
            answer *= map.get(value) + 1;
        }
        answer -= 1;
        return answer;
    }
}
