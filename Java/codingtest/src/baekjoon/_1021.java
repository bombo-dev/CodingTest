package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 원하는 인덱스를 찾기 위해서는 ArrayDeque 로 불가능
 * 따라서 LinkedList 를 통해서 직접 Deque 를 구현해줘야 하는 문제
 * ArrayDeque 는 Array 에 의해서 지원되고 Dynamic 형태를 띄고 있다.
 * 만약 삽입, 삭제에서의 메모리의 변형이 생기게 되면 ArrayDeque 의 성능이 떨어지겠지만
 * 동일한 크기에서의 ArrayDeque 와 LinkedList 를 비교하면, ArrayDeque 는 Cache-locality 에 좀 더 친숙하다.
 * 따라서 LinkedList 와 달리 다음 노드에 대한 추가 참조를 유지하지 않아도 돼서 LinkedList 보다 메모리 효율적이다.
 */
public class _1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;

        for(int i = 0; i < N; i++){
            dq.offer(i + 1);
        }
        st = new StringTokenizer(br.readLine(),  " ");

        for(int i = 0; i < M; i++){
            int findValue = Integer.parseInt(st.nextToken());
            int index = dq.indexOf(findValue);
            int mid = 0;
            if(dq.size() % 2 == 1){
                mid = dq.size() / 2;
            } else {
                mid = dq.size() / 2 - 1;
            }
            if(index <= mid){
                while(dq.peek() != findValue){
                    sum++;
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                while(dq.peek() != findValue){
                    sum++;
                    dq.offerFirst(dq.pollLast());
                }
            }
            dq.pollFirst();
        }

        System.out.print(sum);
    }
}
