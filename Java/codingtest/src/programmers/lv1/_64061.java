package programmers.lv1;

import java.util.Stack;

public class _64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++){
            int col = moves[i] - 1;
            for(int j = 0; j < board.length; j++){
                if(board[j][col] != 0){
                    if(stack.size() != 0 && stack.peek() == board[j][col]){
                        stack.pop();
                        board[j][col] = 0;
                        answer += 2;
                    } else {
                        stack.push(board[j][col]);
                        board[j][col] = 0;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
