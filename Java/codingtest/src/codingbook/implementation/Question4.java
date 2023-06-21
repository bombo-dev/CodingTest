package codingbook.implementation;

import java.io.*;
import java.util.*;
public class Question4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int sizeX = Integer.parseInt(init[0]);
        int sizeY = Integer.parseInt(init[1]);

        // 북, 동, 남, 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] board = new int[sizeX][sizeY];
        String[] position = br.readLine().split(" ");
        int px = Integer.parseInt(position[0]);
        int py = Integer.parseInt(position[1]);
        int d = Integer.parseInt(position[2]);

        int nx = px;
        int ny = py;
        int result = 0;
        int back = 0;
        boolean isMove = true;

        for(int i = 0; i < sizeX; i++) {
            String[] map = br.readLine().split(" ");
            for (int j = 0; j < sizeY; j++) {
                board[i][j] = Integer.parseInt(map[j]);
            }
        }
        board[px][py] = 2; // 방문 테이블 이용 가능
        int count = 0;

        while(isMove){
            back = 0;
            count = 0;
            for(int i = 0; i < 4; i++) {
                if(d - 1 < 0){
                    d = d - 1 + 4;
                } else{
                    d = d - 1;
                }
                nx = px + dx[d];
                ny = py + dy[d];
                if (board[nx][ny] != 1 && board[nx][ny] != 2) {
                    px = nx;
                    py = ny;
                    board[px][py] = 2;
                    result += 1;
                    break;
                }
                count++;
            }
            if(count == 4){
                if(d - 2 < 0){
                    back = d - 2 + 4;
                } else{
                    back = d - 2;
                }
                nx = px + dx[back]; // nx = px - dx[d]
                ny = py + dy[back]; // ny = py - dy[d]
                if(board[nx][ny] == 1){
                    isMove = false;
                    break;
                } else {
                    px = nx;
                    py = ny;
                    result += 1;
                }
            }
        }
        System.out.print(result);
    }
}
