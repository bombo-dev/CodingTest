package baekjoon;

import java.io.*;
import java.util.*;
public class _5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 테스트 케이스 입력
        for(int i = 0; i < N; i++){
            String value = br.readLine();
            // 문자 계산
            String result = keylogger(value);
            System.out.println(result);
        }
    }

    public static String keylogger(String value){
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();
        for(int i = 0; i < value.length(); i++){
            char ch = value.charAt(i);
            if(ch == '<'){
                if(iter.hasPrevious())
                    iter.previous();
            } else if(ch == '>'){
                if(iter.hasNext())
                    iter.next();
            } else if(ch == '-'){
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else {
                iter.add(ch);
            }
        }

        while(iter.hasPrevious()){
            iter.previous();
        }

        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()){
            sb.append(iter.next());
        }
        return sb.toString();
    }
}
