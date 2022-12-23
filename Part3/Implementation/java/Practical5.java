import java.io.*;
import java.util.*;

class Snake {
    private int row;
    private int col;

    public Snake(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
public class Practical5 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //비어있는 위치는 0
        //뱀이 있는 위치는 1
        //사과가 있는 위치는 2

        // 보드의 크기
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1];

        // 벽 또는 자기 자신의 몸과 부딪히면 게임 끝
        // 뱀의 위치를 저장하는 큐 추가
        // [처음, 끝]
        ArrayDeque<Snake> q = new ArrayDeque<>();
        // 처음 뱀의 위치
        q.offer(new Snake(1, 1));
        int time = 0;

        // 오른쪽, 아래, 왼쪽, 위
        // 오른쪽으로 회전 기준
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int direction = 0;

        // 사과의 개수
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            String[] apple = br.readLine().split(" ");
            int row = Integer.parseInt(apple[0]);
            int col = Integer.parseInt(apple[1]);
            board[row][col] = 2;
        }
        // 변환 좌표 저장 배열 생성
        String[] rotate = new String[10001];
        int c = Integer.parseInt(br.readLine());

        // L은 왼쪽으로 90도 이동, D은 오른쪽으로 90도 이동
        for(int i = 0; i < c; i++){
            String[] change = br.readLine().split(" ");
            int x = Integer.parseInt(change[0]);
            String alpha = change[1];
            rotate[x] = alpha;
        }

        while(time <= 10000){
            Snake position = q.peekLast();
            int px = position.getRow();
            int py = position.getCol();
            int nx = px + dx[direction];
            int ny = py + dy[direction];
            time += 1;

            // 벽에 부딪히거나, 다음 위치에 뱀의 몸이 있는 경우
            if(nx < 1 || nx > n || ny < 1 || ny > n || board[nx][ny] == 1)
                break;
            else {
                // 사과가 있는 경우
                if(board[nx][ny] == 2) {
                    q.offer(new Snake(nx, ny));
                    board[nx][ny] = 1;

                } else {
                    q.offer(new Snake(nx, ny));
                    board[nx][ny] = 1;
                    Snake snake = q.pollFirst();
                    board[snake.getRow()][snake.getCol()] = 0;
                }

                if(rotate[time] != null){
                    if(rotate[time].equals("L")){
                        direction = (direction - 1) < 0 ? 3 : direction - 1;
                    } else{
                        direction = (direction + 1) % 4;
                    }
                }
            }
        }
        System.out.print(time);
    }
}
