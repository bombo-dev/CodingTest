import java.io.*;
import java.util.*;
public class _9093B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            char[] s = br.readLine().toCharArray();
            for(char value : s){
                if(value == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }
                else {
                    stack.push(value);
                }
            }
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb);
        }
    }
}
