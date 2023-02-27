package programmers.lv2;

public class _12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        answer = new int[arr1.length][arr2[0].length];

        for(int r = 0; r < arr1.length; r++){
            for(int c = 0; c < arr2[0].length; c++){
                int sum = 0;
                for(int k = 0; k < arr1[0].length; k++){
                    sum += arr1[r][k] * arr2[k][c];
                }
                answer[r][c] = sum;
            }
        }
        return answer;
    }
}
