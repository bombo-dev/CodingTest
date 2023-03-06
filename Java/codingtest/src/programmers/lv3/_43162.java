package programmers.lv3;

import java.util.*;
public class _43162 {
    ArrayList<ArrayList<Integer>> list;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 0; i < n + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(i != j && computers[i][j] == 1){
                    list.get(i + 1).add(j + 1);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int i){
        if(visited[i])
            return;

        visited[i] = true;

        for(int value : list.get(i)){
            dfs(value);
        }
    }
}
