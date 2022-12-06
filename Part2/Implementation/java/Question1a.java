import java.io.*;
import java.util.*;
public class Question1a {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // L, R, U, D -> move_type 지정가능
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] moveType = {"L", "R", "U", "D"};

        String [] direction = br.readLine().split(" ");
        int count = direction.length;

        int px = 1;
        int py = 1;
        int nx = 1;
        int ny = 1;
        for(int i = 0; i < count; i++){
            for(int j = 0; j < moveType.length; j++){
                if(direction[i].equals(moveType[j])){
                    nx = px + dx[j];
                    ny = py + dy[j];
                }
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
