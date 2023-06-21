package baekjoon;

import java.io.*;
import java.util.*;
public class _9093A {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String[] value = br.readLine().split(" ");
            for (String val : value) {
                for (int j = 0; j < val.length(); j++) {
                    stack.push(val.charAt(j));
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
