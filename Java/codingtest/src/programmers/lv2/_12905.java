package programmers.lv2;

public class _12905 {
    int[][] newBoard;
    int max = 0;

    public int solution(int[][] board) {
        newBoard = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i < newBoard.length; i++) {
            for (int j = 1; j < newBoard[i].length; j++) {
                max = Math.max(max, newBoard[i][j]);
                if (newBoard[i][j] != 0 && i < newBoard.length - 1 && j < newBoard[i].length - 1) {
                    if (isSquare(i, j)) {
                        int min = newBoard[i][j];
                        min = Math.min(min, newBoard[i][j + 1]);
                        min = Math.min(min, newBoard[i + 1][j]);
                        newBoard[i + 1][j + 1] = min + 1;
                        max = Math.max(max, newBoard[i + 1][j + 1]);
                    }
                }
            }
        }
        int answer = max * max;
        return answer;
    }

    boolean isSquare(int i, int j) {
        if (newBoard[i][j + 1] == 0) {
            return false;
        }

        if (newBoard[i + 1][j] == 0) {
            return false;
        }

        if (newBoard[i + 1][j + 1] == 0) {
            return false;
        }


        return true;
    }

    void print() {
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                System.out.print(newBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
