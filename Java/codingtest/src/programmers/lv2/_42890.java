package programmers.lv2;

import java.util.*;
public class _42890 {

    boolean[] used;
    boolean[] visited;
    Set<String> correct = new HashSet<>();
    List<String> comb;
    int result = 0;
    int rowCount;
    int columnCount;
    public int solution(String[][] relation) {
        init(relation);
        solve(relation);
        return result;
    }

    void init(String[][] relation) {
        rowCount = relation.length;
        columnCount = relation[0].length;
        used = new boolean[columnCount];
        visited = new boolean[columnCount];
    }

    // 처음에는 1개씩, 그 다음에는 2개씩, 그런데 사용된 건 건너뛰어야 함
    void solve(String[][] relation) {
        for(int i = 1; i <= columnCount; i++) {
            dfs(0, i, relation);
        }
    }

    void dfs(int counting, int find, String[][] relation) {

        if(counting == find) {
            compare(relation);
            return;
        }

        for(int i = 0; i < columnCount; i++) {
            if(used[i] || visited[i])
                continue;

            visited[i] = true;
            dfs(counting + 1, find, relation);
            visited[i] = false;
        }
    }

    void compare(String[][] relation) {
        List<Integer> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String answer = "";

        for(int i = 0; i < columnCount; i++) {
            if(visited[i]){
                list.add(i);
                list2.add(String.valueOf(i));
                answer += i;
            }
        }

        Set<String> set = new HashSet<>();

        for(String s : correct) {
            List<String> list1 = Arrays.asList(s.split(""));
            if(list2.containsAll(list1))
                return;
        }

        for(int i = 0; i < rowCount; i++) {
            StringBuilder sb = new StringBuilder();

            for(int col : list) {
                sb.append(relation[i][col]);
            }

            if(!set.add(sb.toString()))
                return;
        }

        correct.add(answer);
        result++;
    }
}
