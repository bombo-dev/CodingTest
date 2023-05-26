package programmers.lv2;

import java.util.*;
public class _86971 {
    int min = Integer.MAX_VALUE;
    boolean [] visited;
    ArrayList<ArrayList<Integer>> list;
    public int solution(int n, int[][] wires) {
        solve(n, wires);
        return min;
    }

    void solve(int n, int[][] wires) {
        for(int i = 0; i < wires.length; i++) {
            list = initList(n);
            updateList(i, wires);
            calcDiff(n);
        }
    }

    ArrayList<ArrayList<Integer>> initList(int n) {
        visited = new boolean[n + 1];
        list = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        return list;
    }

    void updateList(int i, int[][] wires) {
        for(int w = 0; w < wires.length; w++) {
            if(w == i)
                continue;
            int start = wires[w][0];
            int end = wires[w][1];

            list.get(start).add(end);
            list.get(end).add(start);
        }
    }

    void print(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.println(i + "스타팅 포인트 시작");
            for(int end : list.get(i)) {
                System.out.print(end + " ");
            }
            System.out.println();
        }
    }

    void calcDiff(int n) {
        boolean isFirst = false;
        int first = 0;
        int second = 0;

        for(int i = 1; i <= n; i++) {
            if(!visited[i]){
                if(!isFirst){
                    first = bfs(i);
                    isFirst = true;
                }
                else
                    second = bfs(i);
            }
        }
        min = Math.min(min, Math.abs(first-second));
    }

    int bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        int count = 1;

        for(int end : list.get(i)) {
            q.offer(end);
            visited[end] = true;
        }

        while(!q.isEmpty()) {
            int link = q.poll();
            count++;
            for(int end : list.get(link)) {
                if(!visited[end]){
                    q.offer(end);
                    visited[end] = true;
                }
            }
        }

        return count;
    }
}
