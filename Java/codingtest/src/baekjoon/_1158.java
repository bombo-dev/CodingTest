package baekjoon;

import java.io.*;
import java.util.*;
public class _1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        josephus(sb, list, K);
        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        System.out.println(sb.toString());
    }

    public static void josephus(StringBuilder sb, LinkedList<Integer> list, int K){
        int index = 0;
        int value = 0;
        ListIterator<Integer> iter = list.listIterator();

        while(list.size() != 0){
            if(iter.hasNext()){
                value = iter.next();
            } else {
                iter = list.listIterator();
                value = iter.next();
            }
            if(++index % K == 0){
                sb.append(value + ", ");
                iter.remove();
            }
        }
    }
}
