package baekjoon;

import java.io.*;
import java.util.*;


public class _17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

        Stack<Top> stack = new Stack<>();
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());
            // 1. 처음 시작할 경우
            if(stack.isEmpty()){
                stack.push(new Top(i, value));
            } else {
                // 2. 값이 들어 있을 경우
                while(!stack.isEmpty()){
                    if(stack.peek().height < value){
                        result[stack.pop().index] = value;
                    } else {
                        break;
                    }
                }
                stack.push(new Top(i, value));
            }
        }

        while(!stack.isEmpty()){
            result[stack.pop().index] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(result[i] + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }
}
