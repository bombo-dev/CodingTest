package input;

import java.io.*;

public class CodeUp1099 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] maze = new int[10][10];
        for(int i = 0; i < 10; i++){
            String [] cc = br.readLine().split(" ");
            for(int j = 0; j < 10; j++){
                maze[i][j] = Integer.parseInt(cc[j]);
            }
        }
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean ant = true;
        int direction = 0;
        int pX = 1;
        int pY = 1;

        if(maze[pX][pY] == 2){
            maze[pX][pY] = 9;
        } else {
            while(ant){
                maze[pX][pY] = 9;

                if(maze[pX][pY + 1] == 2 || maze[pX][pY + 1] == 0){
                    direction = 0;
                } else {
                    direction = 1;
                }

                int nx = pX + dx[direction];
                int ny = pY + dy[direction];

                if(direction == 1){
                    if(maze[nx][ny] == 1){
                        ant = false;
                        break;
                    }
                }
                if(nx == 8 && ny == 8){
                    maze[nx][ny] = 9;
                    ant = false;
                } else {
                    if(maze[nx][ny] == 2){
                        pX = nx;
                        pY = ny;
                        maze[pX][pY] = 9;
                        ant = false;
                    } else {
                        pX = nx;
                        pY = ny;
                    }
                }
            }
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
