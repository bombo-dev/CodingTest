package programmers.lv2;

import java.util.*;

public class _154540 {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    String[][] toMaps;
    boolean[][] visited;
    int row;
    int col;
    int count = 0;
    List<Integer> list = new ArrayList<>();

    public int[] solution(String[] maps) {
        init(maps);
        solve();
        if(list.size() == 0)
            return new int[]{-1};
        int[] answer = new int[list.size()];
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void init(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        visited = new boolean[row][col];
        toMaps = new String[row][col];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'X')
                    visited[i][j] = true;
                toMaps[i][j] = String.valueOf(maps[i].charAt(j));
            }
        }
    }

    public void solve() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visited[i][j]) {
                    int count = bfs(i, j);

                    if(count > 0)
                        list.add(count);
                }
            }
        }
    }

    public int bfs(int x, int y) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] position = q.poll();
            int px = position[0];
            int py = position[1];
            count += Integer.parseInt(toMaps[px][py]);

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return count;
    }
}
