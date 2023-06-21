package baekjoon;

import java.io.*;
public class _9012A {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int count = 0;
            char[] s = br.readLine().toCharArray();
            for(char c : s){
                if(c == '('){
                    count++;
                } else {
                    count--;
                }
            }
            if(count != 0){
                System.out.println("NO");
            } else{
                System.out.println("YES");
            }
        }
    }
}
