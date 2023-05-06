package programmers.lv2;

import java.util.*;
public class _72411 {
    static Map<String, Integer> food = new HashMap<>();
    static boolean[] courseFlag = new boolean[11];
    static Map<Integer, Integer> maxMap = new HashMap<>();
    static List<String> courseList = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        init(orders, course);
        String[] answer = solve(orders);
        return answer;
    }

    void init(String[] orders, int[] course) {
        for(int value : course) {
            courseFlag[value] = true;
            maxMap.put(value, 0);
        }
    }

    String[] solve(String[] order) {
        for(int i = 0; i < order.length; i++) {
            StringBuilder sb = new StringBuilder();
            boolean[] visited = new boolean[order[i].length()];
            char[] foodArr = order[i].toCharArray();
            Arrays.sort(foodArr);

            findCourse(foodArr, visited, sb, 0);
        }

        String[] answer = classification();
        return answer;
    }

    void findCourse(char[] order, boolean[] visited, StringBuilder sb, int start) {

        if(courseFlag[sb.length()]) {
            String comb = sb.toString();
            food.put(comb, food.getOrDefault(comb, 0) + 1);
            if(maxMap.get(sb.length()) < food.get(comb)) {
                maxMap.put(sb.length(), food.get(comb));
            }
        }

        for(int i = start; i < order.length; i++) {
            sb.append(order[i]);
            findCourse(order, visited, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    String[] classification() {
        for(String key : food.keySet()) {
            if(food.get(key) == maxMap.get(key.length()) && food.get(key) >= 2) {
                courseList.add(key);
            }
        }
        Collections.sort(courseList);

        String[] answer = new String[courseList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = courseList.get(i);
        }

        return answer;
    }

    void printList() {
        StringJoiner joiner = new StringJoiner(", ");
        for(String value : courseList) {
            joiner.add(value);
        }
        System.out.print(joiner);
    }
}
