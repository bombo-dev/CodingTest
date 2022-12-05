import java.io.*;
import java.util.*;
public class Question2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] card = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] number = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                card[i][j] = Integer.parseInt(number[j]);
            }
        }
        List<int[]> list = new ArrayList<>(Arrays.asList(card));
        for(int i = 0; i < list.size(); i++){
            Arrays.sort(list.get(i));
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            if(result < card[i][0]) {
                result = card[i][0];
            }
        }
        System.out.print(result);
    }
}
