package programmers.lv2;

import java.util.*;
public class _81302 {
    int[] udlrX = {-1, 0, 1, 0};
    int[] udlrY = {0, 1, 0, -1};
    int[] diaX = {-1, -1, 1, 1};
    int[] diaY = {-1, 1, 1, -1};

    List<Integer> list = new ArrayList<>();
    List<int[]> position;
    char[][] map;

    public int[] solution(String[][] places) {
        for(int i = 0; i < places.length; i++) {
            solve(places, i);
        }
        return toArray();
    }

    void solve(String[][] places, int i) {
        init(places, i);
        if(judgment(places.length))
            list.add(1);
        else
            list.add(0);
    }

    void init(String[][] places, int i) {
        int length = places.length;
        map = new char[length][length];
        position = new ArrayList<>();

        for(int x = 0; x < length; x++) {
            String value = places[i][x];
            for(int y = 0; y < length; y++) {
                map[x][y] = value.charAt(y);
                if(map[x][y] == 'P')
                    position.add(new int[]{x, y});
            }
        }
    }

    boolean judgment(int length) {
        int count = 0;

        for(int[] pos : position) {
            count++;

            int x = pos[0];
            int y = pos[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + udlrX[i];
                int ny = y + udlrY[i];

                if(nx < 0 || nx >= length || ny < 0 || ny >= length)
                    continue;

                if(map[nx][ny] == 'P') {
                    return false;
                }

                if(map[nx][ny] == 'O') {
                    int nnx = nx + udlrX[i];
                    int nny = ny + udlrY[i];

                    if(nnx < 0 || nnx >= length || nny < 0 || nny >= length)
                        continue;

                    if(map[nnx][nny] == 'P')
                        return false;
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + diaX[i];
                int ny = y + diaY[i];

                if(nx < 0 || nx >= length || ny < 0 || ny >= length)
                    continue;

                if(map[nx][ny] == 'P') {
                    if(map[nx][y] == 'O' || map[x][ny] == 'O')
                        return false;
                }
            }
        }

        return true;
    }

    /* 출력
    void print(int size) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    */

    int[] toArray() {
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
