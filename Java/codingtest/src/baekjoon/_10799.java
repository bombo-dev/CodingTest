package baekjoon;

import java.io.*;
import java.util.*;
public class _10799 {
    // 끝점 겹치면 안됨
    // () 레이저 발사
    // 열릴 때 마다 쇠막대기 추가
    // 닫힐 때 개수 추가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int total = 0;
        int iron = 0;
        boolean previous = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push('(');
                continue;
            }
            if (ch == ')') {
                stack.pop();
                if (s.charAt(i - 1) == '(')
                    total += stack.size();
                else {
                    total++;
                }
            }
        }
        System.out.print(total);
    }
}
