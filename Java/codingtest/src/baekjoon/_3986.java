package baekjoon;

import java.io.*;
import java.util.*;
public class _3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int total = 0;

        for(int i = 0; i < N; i++){
            Stack<Character> stack = new Stack<>();
            String value = br.readLine();
            for(int j = 0; j < value.length(); j++){
                char ch = value.charAt(j);
                if(stack.isEmpty()){
                    stack.push(ch);
                } else {
                    if(stack.peek() == ch){
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }
            if(stack.isEmpty())
                total++;
        }

        System.out.print(total);
    }
}