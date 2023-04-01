package baekjoon;

import java.io.*;
import java.util.*;

class FindRoute implements Comparable<FindRoute> {
    int x;
    int time;

    public FindRoute(int x, int time) {
        this.x = x;
        this.time = time;
    }

    @Override
    public int compareTo(FindRoute o) {
        return time - o.time;
    }
}

// 스택을 사용해서 부모 관리가 가능 함. BFS 로 다시 역추적하기 보다 BFS 에 값 갱신 때 부모 갱신
public class _13913 {
    static int N;
    static int K;
    static int[] time = new int[100001];
    static int maxSize = 100000;
    static int min = Integer.MAX_VALUE;

    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        Arrays.fill(time, Integer.MAX_VALUE);

        bfs();
        findPosition();
        System.out.println(time[K]);
        System.out.println(sb.toString());
    }

    // 최소 값 찾기
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        time[N] = 0;

        while(!q.isEmpty()) {
            int x = q.poll();

            if(x == K) {
                min = Math.min(min, time[K]);
                return;
            }

            if(x * 2 <= maxSize && time[x * 2] > time[x] + 1) {
                q.offer(x * 2);
                time[x * 2] = time[x] + 1;
            }

            if(x + 1 <= maxSize && time[x + 1] > time[x] + 1) {
                q.offer(x + 1);
                time[x + 1] = time[x] + 1;
            }

            if(x - 1 >= 0 && time[x - 1] > time[x] + 1) {
                q.offer(x - 1);
                time[x - 1] = time[x] + 1;
            }
        }
    }

    // 최소값 따라가기 DFS
    public static void findPosition(int find) {

        sb.append(find).append(" ");
        System.out.println("DFS 실행 중");

        if(find == K)
            return;

        if(find * 2 <= maxSize && time[find * 2] == time[find] + 1)
            findPosition(find * 2);

        if(find + 1 <= maxSize && time[find + 1] == time[find] + 1)
            findPosition(find + 1);

        if(find - 1 >= 0 && time[find - 1] == time[find]) {
            findPosition(find - 1);
        }
    }

    public static void findPosition() {
        PriorityQueue<FindRoute> pq = new PriorityQueue<>();
        pq.offer(new FindRoute(K, time[K]));

        while(!pq.isEmpty()) {
            FindRoute find = pq.poll();
            int x = find.x;
            int t = find.time;
            sb.insert(0,x + " ");

            if(x == N)
                return;

            if(x % 2 == 0) {
                if(x / 2 > 0 && time[x / 2] == t - 1)
                    pq.offer(new FindRoute(x / 2, time[x / 2]));
                if(x - 1 >= 0 && time[x - 1] == t - 1)
                    pq.offer(new FindRoute(x - 1, time[x - 1]));
                if(x + 1 <= maxSize && time[x + 1] == t - 1)
                    pq.offer(new FindRoute(x + 1, time[x + 1]));
            } else {
                if(x - 1 >= 0 && time[x - 1] == t - 1)
                    pq.offer(new FindRoute(x - 1, time[x - 1]));
                if(x + 1 <= maxSize && time[x + 1] == t - 1)
                    pq.offer(new FindRoute(x + 1, time[x + 1]));
            }
        }
    }
}
