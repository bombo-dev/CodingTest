package programmers.lv2;
import java.util.*;
public class _77485 {
    List<Integer> list = new ArrayList<>();
    int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        init(rows, columns);
        solve(queries);

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public void init(int row, int col) {
        map = new int[row][col];
        int value = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = ++value;
            }
        }
    }

    public void print() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(int[][] queries) {

        for(int T = 0; T < queries.length; T++) {
            int minValue = Integer.MAX_VALUE;
            int saveValue = 0;
            int lastValue = 0;
            int x1 = queries[T][0] - 1;
            int y1 = queries[T][1] - 1;
            int x2 = queries[T][2] - 1;
            int y2 = queries[T][3] - 1;

            // 1번 단계 수행
            for(int i = y2; i > y1; i--) {
                if(i == y2) {
                    lastValue = map[x1][y2];
                }

                map[x1][i] = map[x1][i - 1];
                minValue = Math.min(minValue, map[x1][i - 1]);
            }
            saveValue = lastValue;
            // 2번 단계 수행
            for(int i = x2; i > x1; i--) {

                if(i == x2) {
                    lastValue = map[x2][y2];
                }

                if(i == x1 + 1) {
                    map[i][y2] = saveValue;
                } else {
                    map[i][y2] = map[i - 1][y2];
                }
                minValue = Math.min(minValue, map[i - 1][y2]);
            }
            saveValue = lastValue;
            // 3번 단계 수행
            for(int i = y1; i < y2; i++) {
                if(i == y1) {
                    lastValue = map[x2][y1];
                }

                if(i == y2 - 1) {
                    map[x2][i] = saveValue;
                } else {
                    map[x2][i] = map[x2][i + 1];
                }
                minValue = Math.min(minValue, map[x2][i + 1]);
            }
            saveValue = lastValue;
            // 4번 단계 수행
            for(int i = x1; i < x2; i++) {
                if(i == x2 - 1) {
                    map[i][y1] = saveValue;
                } else {
                    map[i][y1] = map[i + 1][y1];
                }
                minValue = Math.min(minValue, map[i + 1][y1]);
            }
            // 모든 수행 후 리스트에 최솟값 삽입
            list.add(minValue);

        }
    }
}
