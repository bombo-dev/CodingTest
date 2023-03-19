package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 128MB = int 3200만, char 1억 2800만
 *
 */
public class _4949 {

    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            stack = new Stack<>();
            boolean balance = true;
            String str = br.readLine();
            if(str.charAt(0) == '.' && str.length() == 1)
                break;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '['){
                    stack.push(str.charAt(i));
                } else if(str.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek() != '('){
                        balance = false;
                        break;
                    } else if (stack.isEmpty()){
                        balance = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if(str.charAt(i) == ']') {
                    if(!stack.isEmpty() && stack.peek() != '[') {
                        balance = false;
                        break;
                    } else if (stack.isEmpty()){
                        balance = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(!balance || !stack.isEmpty())
                System.out.println("no");
            else
                System.out.println("yes");
        }

    }
}
