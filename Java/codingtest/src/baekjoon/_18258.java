package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 큐 문제와 다른 점은, 기존의 큐 문제에서 의도 했던 부분은 N 이 10000으로,
 * back을 확인 할 때, back 의 인덱스를 확인 할 때 까지 index 번호를 늘려가면서, 맨 앞 요소를 뒤로 넘기고
 * index가 size에 도달했을 때, 뽑는 형식을 의도했던 것 같다.
 * 그러나 push 시 back 을 유지해두면 이를 간단히 해결할 수 있다.
 */
public class _18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int back = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            switch(command){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    q.offer(value);
                    back = value;
                    break;
                case "front":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(back).append("\n");
                    }
                    break;
                case "pop":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
