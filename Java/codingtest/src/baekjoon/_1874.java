package baekjoon;


import java.io.*;
import java.util.*;

public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int index = 0;
        int startValue = 1;
        StringBuilder sb = new StringBuilder();


        while(startValue <= N){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() == arr[index]) {
                    sb.append("-\n");
                    stack.pop();
                    index++;
                }
            }
            stack.push(startValue);
            sb.append("+\n");
            startValue++;
        }

        while(!stack.isEmpty()){
            if(stack.peek() == arr[index]){
                sb.append("-\n");
                stack.pop();
                index++;
            } else {
                break;
            }
        }

        if(!stack.isEmpty())
            System.out.println("NO");
        else
            System.out.println(sb.toString());
    }
}
