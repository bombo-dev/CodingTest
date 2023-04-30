package programmers.lv2;

import java.util.*;
public class _154538 {
    static boolean[] visited;

    public int solution(int x, int y, int n) {
        int answer = 0;
        visited = new boolean[y + 1];
        answer = findResult(x, y, n);
        return answer;
    }

    int findResult(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0});

        while(!q.isEmpty()) {
            int[] po = q.poll();
            int value = po[0];
            int count = po[1];

            if(value == y)
                return count;

            if(value * 3 <= y && !visited[value * 3]) {
                q.offer(new int[]{value * 3, count + 1});
                visited[value * 3] = true;
            }
            if(value * 2 <= y && !visited[value * 2]) {
                q.offer(new int[]{value * 2, count + 1});
                visited[value * 2] = true;
            }
            if(value + n <= y && !visited[value + n]) {
                q.offer(new int[]{value + n, count + 1});
                visited[value + n] = true;
            }
        }
        return -1;
    }
}
