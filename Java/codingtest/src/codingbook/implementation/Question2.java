package codingbook.implementation;

import java.io.*;
import java.util.*;
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine().trim();

        int result = 0;

        for(int i = 0; i < Integer.parseInt(N) + 1; i++){
            for(int j = 0; j <= 59; j++){
                for (int k = 0; k <= 59; k++){
                    String s = i + " " + j + " " + k;
                    if(s.contains("3")){
                        result += 1;
                    }
                }
            }
        }
        System.out.print(result);
    }
}
