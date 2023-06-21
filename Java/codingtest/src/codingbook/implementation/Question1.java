package codingbook.implementation;

import java.io.*;
import java.util.*;
public class Question1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // L, R, U, D
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        String [] direction = br.readLine().split(" ");
        int count = direction.length;

        int px = 1;
        int py = 1;
        int nx = 1;
        int ny = 1;
        for(int i = 0; i < count; i++){
            if(direction[i].equals("L")){
                nx = px + dx[0];
                ny = py + dy[0];
            } else if(direction[i].equals("R")){
                nx = px + dx[1];
                ny = py + dy[1];
            } else if(direction[i].equals("U")){
                nx = px + dx[2];
                ny = py + dy[2];
            } else{
                nx = px + dx[3];
                ny = py + dy[3];
            }
            if(nx < 1 || nx > 5 || ny < 1 || ny > 5){
                continue;
            }
            px = nx;
            py = ny;
        }
        System.out.print(px + " " + py);
    }
}
