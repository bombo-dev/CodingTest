package baekjoon;

import java.io.*;
import java.util.*;
public class _5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 테스트 수행
        for(int i = 0; i < T; i++){
            boolean normal = true;
            boolean reverse = false;
            String command = br.readLine();
            // 사이즈 빼기
            int size = Integer.parseInt(br.readLine());
            String elements = br.readLine();
            // 원소 포맷팅
            elements = format(elements);
            StringTokenizer st = new StringTokenizer(elements, ",");

            LinkedList<String> list = new LinkedList<>();
            while(st.hasMoreElements()) {
                list.add(st.nextToken());
            }
            ListIterator it = list.listIterator();

            // 명령어 수행
            for(int j = 0; j < command.length(); j++){
                if(command.charAt(j) == 'R') {
                    if(!reverse) {
                        reverse = true;
                        it = list.listIterator(list.size());
                    } else {
                        reverse = false;
                        it = list.listIterator();
                    }
                } else if(command.charAt(j) == 'D') {
                    if(list.size() == 0) {
                        normal = false;
                        break;
                    } else {
                        if (!reverse) {
                            it.next();
                            it.remove();
                        } else {
                            it.previous();
                            it.remove();
                        }
                    }
                }
            }

            if(normal){
                print(list, reverse);
            } else {
                System.out.println("error");
            }
        }

    }
    public static String format(String elements){
        StringBuilder sb = new StringBuilder();
        sb.append(elements);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void print(LinkedList<String> list, boolean reverse) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListIterator it = null;
        if(!reverse) {
            it = list.listIterator();
            while(it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
        } else {
            it = list.listIterator(list.size());
            while(it.hasPrevious()) {
                sb.append(it.previous());
                sb.append(",");
            }
        }
        if(list.size() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
