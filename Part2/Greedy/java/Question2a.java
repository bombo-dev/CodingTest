import java.io.*;


public class Question2a {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int result = 0;
        int minValue = 10001;

        for(int i = 0; i < N; i++){
            String[] number = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                minValue = Math.min(Integer.parseInt(number[j]), minValue);
            }
            result = Math.max(minValue, result);
            minValue = 10001;
        }
        System.out.print(result);
    }
}
