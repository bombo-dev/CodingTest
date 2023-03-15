package baekjoon;

import java.io.*;
import java.util.*;

public class _10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            if(value == 0)
                ans -= stack.pop();
            else
                ans += stack.push(value);
        }

        System.out.println(ans);
    }
}
