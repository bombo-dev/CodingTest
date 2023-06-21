package codingbook.greedy.practical;

import java.io.*;

public class Practical5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int weight = Integer.parseInt(init[1]);

        int[] ball = new int[n];
        String[] list = br.readLine().split(" ");

        for(int i = 0; i < list.length; i++){
            ball[i] = Integer.parseInt(list[i]);
        }

        int result = 0;

        for(int i = 0; i < ball.length - 1; i++){
            for(int j = i + 1; j < ball.length; j++){
                if(ball[i] != ball[j]){
                    result += 1;
                }
            }
        }
        System.out.print(result);
    }
}
