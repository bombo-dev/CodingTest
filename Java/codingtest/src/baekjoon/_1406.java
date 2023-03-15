package baekjoon;

import java.io.*;
import java.util.*;
public class _1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList();
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator(list.size());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            switch(c){
                case 'L' :
                    if(iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D' :
                    if(iter.hasNext()){
                        iter.next();
                    }
                    break;
                case 'B' :
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P' :
                    char x = st.nextToken().charAt(0);
                    iter.add(x);
                    break;
            }
        }

        for(char ch : list){
            bw.write(ch);
        }

        bw.flush();
        bw.close();
    }
}
