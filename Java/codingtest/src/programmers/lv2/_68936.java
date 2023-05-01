package programmers.lv2;

public class _68936 {
    static int zeroCount = 0;
    static int oneCount = 0;
    public int[] solution(int[][] arr) {
        recursion(0, 0, arr.length, arr);
        int[] answer = {zeroCount, oneCount};
        return answer;
    }

    void recursion(int r, int c, int size, int[][] arr) {
        boolean isSame = true;
        int initValue = arr[r][c];
        int nextSize = size / 2;
        loop1: for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(arr[i][j] != initValue) {
                    isSame = false;
                    recursion(r, c, nextSize, arr);
                    recursion(r, c + nextSize, nextSize, arr);
                    recursion(r + nextSize, c, nextSize, arr);
                    recursion(r + nextSize, c + nextSize, nextSize, arr);
                    break loop1;
                }
            }
        }

        if(isSame) {
            if(initValue == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
    }
}
