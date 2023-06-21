package codingbook.greedy;

import java.io.*;
public class Question3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int result = 0;

        while(n != 1){
            if(n % m == 0){
                n /= m;
                result += 1;
            } else{
                n -= 1;
                result += 1;
            }
        }
        System.out.print(result);
    }
}
