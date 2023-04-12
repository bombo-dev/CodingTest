package baekjoon;

import java.io.*;
import java.util.*;


public class _18808 {
    static int N;
    static int M;
    static int K;
    static int answer = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0; i < K; i++) {
            // 새 배열 생성
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[][] sticky = new int[a][b];
            int total = 0;
            for(int r = 0; r < a; r++) {
                String[] value = br.readLine().split(" ");
                for(int c = 0; c < b; c++) {
                    sticky[r][c] = Integer.parseInt(value[c]);
                    if(sticky[r][c] == 1)
                        total++;
                }
            }
            // 회전
            for(int rotate = 0; rotate < 4; rotate++) {
                if(rotate >= 1) {
                    sticky = rotate(sticky);
                }
                boolean result = find(sticky, total);

                if(result)
                    break;
            }
        }
        System.out.print(answer);
    }

    static int[][] rotate(int[][] sticky) {
        int preN = sticky.length;
        int preM = sticky[0].length;
        int[][] new_sticky = new int[preM][preN];

        for(int i = 0; i < preN; i++) {
            for(int j = 0; j < preM; j++) {
                new_sticky[j][i] = sticky[preN - 1 - i][j];
            }
        }
        return new_sticky;
    }

    static boolean find(int[][] sticky, int total) {
        int rowSize = sticky.length;
        int colSize = sticky[0].length;

        for(int a = 0; a < N - rowSize + 1; a++) {
            for(int b = 0; b < M - colSize + 1; b++) {
                int[][] new_board = copyBoard();
                int result = 0;
                Loop1: for(int i = 0; i < rowSize; i++) {
                    for(int j = 0; j < colSize; j++) {
                        if(new_board[a + i][b + j] != 1) {
                            new_board[a + i][b + j] = sticky[i][j];
                            result += new_board[a + i][b + j];
                        }
                    }
                    if(result > total)
                        break Loop1;
                }
                if(result == total) {
                    for(int i = 0; i < N; i++) {
                        board[i] = new_board[i].clone();
                    }
                    answer += total;
                    return true;
                }
            }
        }
        return false;
    }

    static int[][] copyBoard() {
        int[][] new_board = new int[N][M];
        for(int i = 0; i < board.length; i++) {
            new_board[i] = board[i].clone();
        }
        return new_board;
    }

    static void print() {
        System.out.println("======= 노트북 출력 =======");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============");
    }

    static void printSticky(int[][] sticky) {
        System.out.println("======== 스티커 포맷 출력 ========");
        for(int i = 0; i < sticky.length; i++) {
            for(int j = 0; j < sticky[i].length; j++) {
                System.out.print(sticky[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }
}
