import java.io.*;
import java.util.*;
public class Question3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int px = (int)s.charAt(0) - (int)'a' + 1;
        int py = Character.getNumericValue(s.charAt(1));

        int[] dx = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};

        int result = 0;
        for(int i = 0; i < 8; i++){
            int nx = px + dx[i];
            int ny = py + dy[i];
            if(nx < 1 || nx > 8 || ny < 1 || ny > 8){
                continue;
            }
            result += 1;
        }
        System.out.print(result);
    }
}
