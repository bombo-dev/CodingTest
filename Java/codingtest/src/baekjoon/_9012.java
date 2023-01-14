package baekjoon;

import java.io.*;
import java.util.*;
public class _9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            char[] value = br.readLine().toCharArray();
            boolean isVPS = true;
            for(char c : value){
                if(c == '(') {
                    stack.push(c);
                }
                else{
                    if(stack.isEmpty()) {
                        isVPS = false;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                isVPS = false;
            }
            if(isVPS){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
            stack.clear();
        }
    }
}
