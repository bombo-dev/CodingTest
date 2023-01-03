package programmers.lv2;

import java.util.*;
// 테이블 해시 함수
public class _147354 {


    public static void main(String[] args){
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        solution(data, 2, 1, 3);
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>(){

            @Override
            public int compare(int[] data1, int[] data2){
                int result = 0;
                result = data1[col - 1] - data2[col - 1];
                if(result == 0){
                    result = data2[0] - data1[0];
                }
                return result;
            }
        });


        // row_begin = 2 -> [1], row_end = 3 -> [2]
        for(int i = row_begin - 1; i < row_end; i++){
            int second = 0;
            for(int j = 0; j < data[i].length; j++){
                second += data[i][j] % (i + 1);
            }
            answer = answer ^ second;
        }

        return answer;
    }
}
