package programmers.lv1;

import java.util.*;
public class _42748 {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        Integer[] arr = new Integer[array.length];

        for(int i = 0; i < array.length; i++){
            arr[i] = array[i];
        }


        for(int i = 0; i < commands.length; i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            Integer[] new_arr = new Integer[b - a + 1];
            System.arraycopy(arr, a - 1, new_arr, 0, b - a + 1);
            Arrays.sort(new_arr);
            answer.add(new_arr[c - 1]);
        }
        return answer;
    }

    // 회고해야 될 부분 Arrays.copyOfRange()

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
