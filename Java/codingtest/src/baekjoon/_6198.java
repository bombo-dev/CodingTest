package baekjoon;

import java.io.*;
import java.util.*;


/**
 * 모노스택 이론
 * 기본적인 스택 기능을 가지며 모든 원소들이 오름차순(혹은 내림차순)을 유지하도록 하는 것
 */
public class _6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        long sum = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()){
                if(height > stack.peek()){
                    stack.pop();
                } else {
                    break;
                }
            }

            sum += stack.size();
            stack.push(height);

        }
        System.out.print(sum);
    }
}
