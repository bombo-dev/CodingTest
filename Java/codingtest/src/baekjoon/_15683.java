package baekjoon;

import java.io.*;
import java.util.*;

class CCTV {
    int x;
    int y;
    int number;

    CCTV(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
}

// 모듈화를 하고, 각 케이스 별로 이동 방향을 체크해준다. 그 방향에 따라 가능하도록 케이스 별로 배열화 한다.
public class _15683 {
    static int N;
    static int M;
    static int[][] board;
    static int[][] searchBoard;
    static Queue<CCTV> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        searchBoard = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                board[i][j] = number;
                searchBoard[i][j] = number;
                if(number != 0) {
                    if(number != 6) {
                        q.offer(new CCTV(i, j, number));
                    }
                }
            }
        }
        int size = q.size();

        for(int i = 0; i < size; i++){
            int result = ccRange(q.poll());
        }

        int noSee = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if(searchBoard[i][j] == 0) {
                    noSee++;
                }
            }
        }

        System.out.print(noSee);
    }

    static int ccRange(CCTV c){
        if(c.number == 1) {
            return first(c);
        } else if(c.number == 2) {
            return second(c);
        } else if(c.number == 3) {
            return third(c);
        } else if(c.number == 4) {
            return fourth(c);
        } else {
            return fifth(c);
        }
    }

    static int first(CCTV c) {

        int max = 0;

        int max_select = 0;

        int px = c.x;
        int py = c.y;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        for(int i = 0; i < 4; i++){
            int count = 0;
            int nx = px;
            int ny = py;

            nx += dx[i];
            ny += dy[i];

            while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 6) {
                if(searchBoard[nx][ny] != -1) {
                    count++;
                }
                nx += dx[i];
                ny += dy[i];
            }

            if(max < count) {
                max_select = i;
                max = count;
            }
        }

        int rx = px + dx[max_select];
        int ry = py + dy[max_select];

        while(rx >= 0 && rx < N && ry >= 0 && ry < M && board[rx][ry] != 6) {
            searchBoard[rx][ry] = -1;
            rx += dx[max_select];
            ry += dy[max_select];
        }

        return max;
    }

    static int second(CCTV c) {
        int max = 0;

        int px = c.x;
        int py = c.y;
        int max_selected = 0;

        int[][] dx = {{0, 0}, {-1, 1}};
        int[][] dy = {{-1, 1}, {0, 0}};

        for(int i = 0; i < 2; i++){
            int count = 0;

            for(int j = 0; j < 2; j++){
                int nx = px + dx[i][j];
                int ny = py + dy[i][j];

                while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 6) {
                    if(searchBoard[nx][ny] != -1) {
                        count++;
                    }
                    nx += dx[i][j];
                    ny += dy[i][j];
                }
            }
            if(max < count) {
                max_selected = i;
                max = count;
            }
        }

        for(int j = 0; j < 2; j++){
            int nx = px + dx[max_selected][j];
            int ny = py + dy[max_selected][j];

            while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 6) {
                searchBoard[nx][ny] = -1;
                nx += dx[max_selected][j];
                ny += dy[max_selected][j];
            }
        }
        return max;
    }

    static int third(CCTV c) {
        int max = 0;

        int px = c.x;
        int py = c.y;
        int max_selected = 0;

        int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] dy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i = 0; i < 4; i++) {
            int cnt = 0;
            int nx = px;
            int ny = py;
            for(int j = 0; j < 2; j++) {
                nx += dx[i][j];
                ny += dy[i][j];

                while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 6) {
                    if(searchBoard[nx][ny] != -1) {
                        cnt++;
                    }
                    nx += dx[i][j];
                    ny += dy[i][j];
                }
            }

            if(max < cnt) {
                max_selected = i;
                max = cnt;
            }
        }

        for(int j = 0; j < 2; j++) {
            int rx = px + dx[max_selected][j];
            int ry = py + dy[max_selected][j];

            while(rx >= 0 && rx < N && ry >= 0 && ry < M && board[rx][ry] != 6) {
                searchBoard[rx][ry] = -1;
                rx += dx[max_selected][j];
                ry += dy[max_selected][j];
            }
        }

        return max;
    }

    static int fourth(CCTV c) {
        int max = 0;
        int px = c.x;
        int py = c.y;
        int max_selected = 0;

        int[][] dx = {{0, -1, 0}, {-1, 0, 1}, {0, 1, 0}, {1, 0, -1}};
        int[][] dy = {{-1, 0, 1}, {0, 1, 0}, {1, 0, -1}, {0, -1, 0}};

        for(int i = 0; i < 4; i++){
            int cnt = 0;
            int nx = px;
            int ny = py;

            for(int j = 0; j < 3; j++) {
                nx += dx[i][j];
                ny += dy[i][j];

                while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 6) {
                    if(searchBoard[nx][ny] != -1) {
                        cnt++;
                    }
                    nx += dx[i][j];
                    ny += dy[i][j];
                }
            }

            if(max < cnt) {
                max_selected = i;
                max = cnt;
            }
        }

        for(int j = 0; j < 3; j++) {
            int rx = px + dx[max_selected][j];
            int ry = py + dy[max_selected][j];

            while(rx >= 0 && rx < N && ry >= 0 && ry < M && board[rx][ry] != 6) {
                searchBoard[rx][ry] = -1;
                rx += dx[max_selected][j];
                ry += dy[max_selected][j];
            }
        }

        return max;
    }

    static int fifth(CCTV c) {
        int max = 0;

        int px = c.x;
        int py = c.y;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0 , 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nx = px + dx[i];
            int ny = py + dy[i];

            while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != 6) {
                searchBoard[nx][ny] = -1;
                nx += dx[i];
                ny += dy[i];
            }
        }
        return max;
    }
}
