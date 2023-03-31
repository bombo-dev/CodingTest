package baekjoon;

import java.io.*;
import java.util.*;

class FindSister implements Comparable<FindSister>{
    int x;
    int value;

    public FindSister(int x, int value) {
        this.x = x;
        this.value = value;
    }


    @Override
    public int compareTo(FindSister o) {
        return this.value - o.value;
    }
}

public class _13549 {
    static int N;
    static int K;
    static boolean[] visited = new boolean[100001];
    static int maxSize = 100001;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        BFS();
        System.out.print(min);
    }

    // Q에 있는 원소들이 해당 범위를 넘어가면 안됐음 예를 들어서, 50001 -> 100002 -> 100001 -> 100000 은 잘못된 풀이
    public static void BFS() {
        Queue<FindSister> q = new LinkedList<>();
        q.offer(new FindSister(N, 0));

        while (!q.isEmpty()) {
            FindSister p = q.poll();

            visited[p.x] = true;

            if(p.x == K) {
                min = Math.min(min, p.value);
            }

            if(p.x * 2 < maxSize && !visited[p.x * 2]) {
                q.offer(new FindSister(p.x * 2, p.value));
            }

            if(p.x - 1 >= 0 && !visited[p.x - 1]) {
                q.offer(new FindSister(p.x - 1, p.value + 1));
            }

            if(p.x + 1 < maxSize && !visited[p.x + 1]) {
                q.offer(new FindSister(p.x + 1, p.value + 1));
            }

        }
    }
}
